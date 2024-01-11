import java.util.Scanner;

/*
This program uses integer division on the user-given time in minutes to convert it to hours.
Afterwards, the modulus operator is used on the user-given time in minutes to find the remaider from the integer division.
The time in hours is then printed, and print formatting is used to ensure minutes takes two character spaces.
*/

public class Morton_Problem1{
	public static void main(String[] args) {
		int hours;
		int minutes;
		Scanner scnr = new Scanner(System.in);

		System.out.print("Please input a time in minutes to convert to hh:mm format: ");
		minutes = scnr.nextInt();

		hours = minutes / 60;
		minutes %= 60;

		System.out.print(hours + ":");
		if (minutes < 10) {
			System.out.printf("%02d", minutes);
		}
		else {
			System.out.print(minutes);
		}

	}
}