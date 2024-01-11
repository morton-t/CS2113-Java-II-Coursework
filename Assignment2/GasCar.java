/*
GasCar class - extends the Vehicle class by adding tankCapacity, and fuelType as arguments.
getFuelEfficiency() method calculates the fuel economy by dividing the miles driven by the fuel tank capacity.
Updates car's milage when calculating fuel economy with the miles driven during the test drive.
if clause ensures a valid value is returned in the default instance.
*/

public class GasCar extends Vehicle {
	float tankCapacity;
	String fuelType;
	
	public GasCar(){
		this("Unknown", "Unknown", 0, "Unknown", 0, 0.0F, "Unknown");
	}

	public GasCar(String make, 
					String model, 
					int year,
					String licensePlate,
					int milesDriven,
					float tankCapacity, 
					String fuelType){

		super(make, model, year, licensePlate, milesDriven);

		this.tankCapacity = tankCapacity;
		this.fuelType = fuelType;
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
	public float getFuelEfficiency(int newMiles){
		float mpg = 0.0F;

		if (tankCapacity > 0) {
			milesDriven += newMiles;
			mpg = newMiles / tankCapacity;

			return mpg;
		}
		return mpg;
	}
}