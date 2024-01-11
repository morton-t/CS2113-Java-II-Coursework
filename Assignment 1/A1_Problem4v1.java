import java.util.Scanner;

public class A1_Problem4v1{
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean isBinary = true;
		int tempNum;

		System.out.print("Please input a binary number: ");
		int inputNumber = scnr.nextInt();

		int mathNum = inputNumber;

		while (mathNum != 0) {
			tempNum = mathNum % 10;
			mathNum /= 10;
			if (tempNum != 0 && tempNum != 1) {
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