/*
Polymorphism & Inheritance - creates vehicle objects using child classes for a Gas, Electric, and Hybrid vehicle.
Outputs vehicle information dependent on the type of object constructed.
Provides information on vehicle fuel efficiency and updates the milage on the vehicle using polymorphism.
I originally casted the parent object as a child while showing fuel type etc., but I felt that wasn't the best solution
*/

public class Morton_Assignment2{

	public static void main(String[] args){
		final int miles = 50;

		System.out.println("\n\nTest driving each car for " + miles + " miles. (Default vehicles have no fuel/battery and will not be driven)");


		Vehicle gasDefault = new GasCar();

		System.out.println("\n\nGas - Default:" + 
							"\n\tMake: " + gasDefault.make + 
							"\n\tModel: " +	gasDefault.model + 
							"\n\tYear: " + gasDefault.year + 
							"\n\tLicense Plate: " + gasDefault.licensePlate + 
							"\n\tMilage: " + gasDefault.milesDriven + 
							"\n\tTank Capacity: " + gasDefault.getTankCapacity() + 
							"\n\tFuel Type: " + gasDefault.getFuelType() +  
							"\n\tFuel Efficiency: " + gasDefault.getFuelEfficiency(miles) + " MPG" +  
							"\n\n\tMilage After Test Drive: " + gasDefault.milesDriven);

		Vehicle hondaCivic = new GasCar("Honda", "Civic", 1998, "AC9 6T6", 100000, 20, "Gasoline");

		System.out.println("\n\nGas - Parameterized:" +
							"\n\tMake: " + hondaCivic.make + 
							"\n\tModel: " + hondaCivic.model + 
							"\n\tYear: " + hondaCivic.year + 
							"\n\tLicense Plate: " + hondaCivic.licensePlate + 
							"\n\tMilage: " + hondaCivic.milesDriven + 
							"\n\tTank Capacity: " + hondaCivic.getTankCapacity() + 
							"\n\tFuel Type: " + hondaCivic.getFuelType() + 
							"\n\tFuel Efficiency: " + hondaCivic.getFuelEfficiency(miles) + " MPG" +  
							"\n\n\tMilage After Test Drive: " + hondaCivic.milesDriven);

		Vehicle electricDefault = new ElectricCar();

		System.out.println("\n\nElectric - Default:" +
							"\n\tMake: " + electricDefault.make + 
							"\n\tModel: " + electricDefault.model + 
							"\n\tYear: " + electricDefault.year + 
							"\n\tLicense Plate: " + electricDefault.licensePlate + 
							"\n\tMilage: " + electricDefault.milesDriven + 
							"\n\tBattery Capacity: " + electricDefault.getBatteryCapacity() +
							"\n\tFuel Efficiency: " + electricDefault.getFuelEfficiency(miles) + " MPGe" +  
							"\n\n\tMilage After Test Drive: " + electricDefault.milesDriven);
		
		Vehicle volvoXC40 = new ElectricCar("Volvo", "XC40", 2022, "34G AGL", 10000, 10);

		System.out.println("\n\nElectric - Parameterized:" +
							"\n\tMake: " + volvoXC40.make + 
							"\n\tModel: " + volvoXC40.model + 
							"\n\tYear: " + volvoXC40.year + 
							"\n\tLicense Plate: " + volvoXC40.licensePlate + 
							"\n\tMilage: " + volvoXC40.milesDriven + 
							"\n\tBattery Capacity: " + volvoXC40.getBatteryCapacity() + 
							"\n\tFuel Efficiency: " + volvoXC40.getFuelEfficiency(miles) + " MPGe" +  
							"\n\n\tMilage After Test Drive: " + volvoXC40.milesDriven);

		Vehicle hybridDefault = new HybridCar();

		System.out.println("\n\nHybrid - Default:" +
							"\n\tMake: " + gasDefault.make + 
							"\n\tModel: " + hybridDefault.model + 
							"\n\tYear: " + hybridDefault.year + 
							"\n\tLicense Plate: " + hybridDefault.licensePlate + 
							"\n\tMilage: " + hybridDefault.milesDriven + 
							"\n\tBattery Capacity: " + hybridDefault.getBatteryCapacity() +
							"\n\tTank Capacity: " + hybridDefault.getTankCapacity() +
							"\n\tFuel Type: " + hybridDefault.getFuelType() +
							"\n\tFuel Efficiency: " + hybridDefault.getFuelEfficiency(miles) + " MPG/MPGe" +  
							"\n\n\tMilage After Test Drive: " + hybridDefault.milesDriven);

		Vehicle teslaModel3 = new HybridCar("Tesla", "Model 3", 2022, "BDB 4FA", 5000, 15, 15, "Gasoline");

		System.out.println("\n\nHybrid - Parameterized:" +
							"\n\tMake: " + teslaModel3.make + 
							"\n\tModel: " + teslaModel3.model + 
							"\n\tYear: " + teslaModel3.year + 
							"\n\tLicense Plate: " + teslaModel3.licensePlate + 
							"\n\tMilage: " + teslaModel3.milesDriven + 
							"\n\tBattery Capacity: " + teslaModel3.getBatteryCapacity() +
							"\n\tTank Capacity: " + teslaModel3.getTankCapacity() +
							"\n\tFuel Type: " + teslaModel3.getFuelType() +
							"\n\tFuel Efficiency: " + teslaModel3.getFuelEfficiency(miles) + " MPG/MPGe" +  
							"\n\n\tMilage After Test Drive: " + teslaModel3.milesDriven);
	}
}