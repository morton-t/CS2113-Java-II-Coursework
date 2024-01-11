import java.util.Random;

public class Sawable_Object{
	private double objectDiameter;
	public String objectName;

	public Sawable_Object(){
		this(48.0, "table");
	}

	public Sawable_Object(double objectDiameter, String objectName){
		this.objectDiameter = objectDiameter;
		this.objectName = objectName;
	}
 
	public double sawObject(double remainingDiameter)  throws InterruptedException  {
		Random sawVariance = new Random();
		double sawDepth = sawVariance.nextDouble(2.0);


		if (remainingDiameter > 0.0 && remainingDiameter < sawDepth) {
			Thread.sleep(300);
			System.out.printf("Sawed %.2f" + " inches into the " + this.objectName + ".\n", remainingDiameter);
			remainingDiameter = 0.0;
			objectDiameter = remainingDiameter;
			sawObject(remainingDiameter);
		}		

		else if (remainingDiameter > 0.0){
			remainingDiameter -= sawDepth;
			objectDiameter = remainingDiameter;
			Thread.sleep(300);
			System.out.printf("Sawed %.2f" + " inches into the " + this.objectName + ".\n", sawDepth);
			sawObject(remainingDiameter);
		}

		else {
			System.out.println("The " + this.objectName + " has been sawed in half!");
			return remainingDiameter;
		}

		return remainingDiameter;
	}
}
