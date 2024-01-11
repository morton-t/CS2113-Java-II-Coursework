/*
HybridCar class - extends the Vehicle class by adding batteryCapacity, tankCapacity, and fuelType as arguments.
getFuelEfficiency() method calculates the fuel economy by averaging battery and fuel type fuel economy.
Updates car's milage when calculating fuel economy with the miles driven during the test drive.
if clause ensures a valid value is returned in the default instance.
*/

public class HybridCar extends Vehicle {
	float batteryCapacity;
	float tankCapacity;
	String fuelType;

	public HybridCar(){
		this("Unknown", "Unknown", 0, "Unknown", 0, 0.0F, 0.0F, "Unknown");
	}

	public HybridCar(String make, 
					String model, 
					int year,
					String licensePlate,
					int milesDriven,
					float batteryCapacity,
					float tankCapacity,
					String fuelType){

		super(make, model, year, licensePlate, milesDriven);

		this.tankCapacity = tankCapacity;
		this.fuelType = fuelType;
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String getFuelType(){
		return this.fuelType;
	}

	@Override
	public float getTankCapacity(){
		return this.tankCapacity;
	}

	@Override
	public float getBatteryCapacity(){
		return this.batteryCapacity;
	}

	@Override
	public float getFuelEfficiency(int newMiles){
		float mpg = 0.0F;
		float mpge = 0.0F;

		if (tankCapacity > 0 || batteryCapacity > 0) {
			mpg = newMiles / tankCapacity;
			int kWh = 2;

			if (batteryCapacity > 0) {
				mpge = (newMiles * kWh)/batteryCapacity;
			}

			milesDriven += newMiles;
			mpg = (mpg + mpge) / 2;

			return mpg;
		}
		return mpg;
	}
}