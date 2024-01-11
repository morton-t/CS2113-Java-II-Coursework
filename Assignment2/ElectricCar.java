/*
ElectricCar class - extends the Vehicle class by adding batteryCapacity as an argument.
getFuelEfficiency() method calculates the fuel economy by averaging battery capacity and the cost of electricity.
Updates car's milage when calculating fuel economy with the miles driven during the test drive.
if clause ensures a valid value is returned in the default instance.
*/

public class ElectricCar extends Vehicle {
	float batteryCapacity;

	public ElectricCar(){
		this("Unknown", "Unknown", 0, "Unknown", 0, 0.0F);
	}

	public ElectricCar(String make, 
						String model, 
						int year,
						String licensePlate,
						int milesDriven,
						float batteryCapacity){

		super(make, model, year, licensePlate, milesDriven);

		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public float getBatteryCapacity(){
		return this.batteryCapacity;
	}

	@Override
	public float getFuelEfficiency(int newMiles){
		float mpge = 0.0F;

		if (batteryCapacity > 0) {
			milesDriven += newMiles;
			int kWh = 2;
			mpge = (newMiles * kWh)/batteryCapacity;

			return mpge;
		}
		return mpge;
	}
}