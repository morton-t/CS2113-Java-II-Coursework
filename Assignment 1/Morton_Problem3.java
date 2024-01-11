import java.util.Scanner;

/*
This program takes an input number and uses integer division by 10 until the result of 0 is reached.
If a non-zero number exists in outputNumber, it is shifted to next decimal position by multiplying it by 10.
Afterwards, the input number has mod10 performed on it to retrieve the number in the ones position, then adds it to outputNumber.
Integer division by 10 then shifts the 'tens' position to 'ones' on inputNumber, and the process repeats.
*/

public class Morton_Problem3{
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int outputNumber = 0;
		int inputNumber;

		System.out.print("Please input a number to reverse: ");
		inputNumber = scnr.nextInt();

		while(inputNumber != 0){
			outputNumber *= 10;
			outputNumber += (inputNumber % 10);	
			inputNumber /= 10;				
		}

		System.out.print("Your reversed number is: " + outputNumber);
	}
}