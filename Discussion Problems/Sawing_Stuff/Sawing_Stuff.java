import java.util.Scanner;

public class Sawing_Stuff{
	public static void main(String[] args)  throws InterruptedException  {
		Scanner scnr = new Scanner(System.in);
		System.out.print("What is being sawed?: ");
		String objToSaw = scnr.nextLine();

		System.out.print("\nWhat is the " + objToSaw + "'s diameter in inches?: ");
		double objDiameter = scnr.nextDouble();
		scnr.nextLine();
		System.out.println();

		Sawable_Object object = new Sawable_Object(objDiameter, objToSaw);

		object.sawObject(objDiameter);
	}
}