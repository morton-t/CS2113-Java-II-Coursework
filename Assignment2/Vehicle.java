/*
Vehicle class - Defines the common elements shared by various vehicle types.
Default constructor creates a default vehicle when the class is not passed arguments
Parameterized constructor initializes the Vehicle class with the passed values
Methods provide polymorphism for fuel efficiency & the ability to display battery/tank/fuel type
*/

public class Vehicle{
	String make;
	String model;
	int year;
	String licensePlate;
	int milesDriven;

	public Vehicle(){ 
		this("Unknown", "Unknown", 0, "Unknown", 0);
	}

	public Vehicle(String make, 
					String model, 
					int year,
					String licensePlate, 
					int milesDriven){

		this.make = make;
		this.model = model;
		this.year = year;
		this.licensePlate = licensePlate;
		this.milesDriven = milesDriven;
	}

	public float getBatteryCapacity(){ return 0.0F; }

	public String getFuelType(){ return "Unknown"; }

	public float getTankCapacity(){ return 0.0F; }

	public float getFuelEfficiency(int miles){ return 0.0F; }
}