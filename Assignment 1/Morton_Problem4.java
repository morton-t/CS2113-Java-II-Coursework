import java.util.Scanner;

/*
This program takes a number as input and stores it in a String.
Next, it uses a for loop to iterate through each char in the string, and checks if that char is a '0' or a '1'.
If the char is neither '0' or '1', the loop breaks and isBinary is set to false.
Finally, an if statement checks the truth value of isBinary. The user is then informed their number is not a binary number based on isBinary's truth value.
*/

public class Morton_Problem4{
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean isBinary = true;

		System.out.print("Check if which number is binary?: ");
		String inputNumber = scnr.nextLine(); 

		for (int i = 0; i < inputNumber.length(); ++i) {
			if (inputNumber.charAt(i) != '0' && inputNumber.charAt(i) != '1') {
				isBinary = false;
				break;
			}
		}

		if (!isBinary) {
			System.out.print(inputNumber + " is not a binary number.");
			return;
		}

		System.out.print(inputNumber + " is a binary number.");
	}
}