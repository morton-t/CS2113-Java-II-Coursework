import java.util.Scanner;

/*
This program takes a number from the user, then checks to see if it equals the composite numbers 0 or 1, or a negative number.
Afterwards, a for loop iterates through the numbers from 2 to the given number to check for divisibility.
A second for loop checks divisibility on the number from the first for loop by its increment, up to n - 1, and if it is divisible the number is flagged as not prime.
All prime numbers are printed as they are discovered, then summed in 'sum'. Sum is then printed.
*/


public class Morton_Problem2{
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int sum = 0;
		int n;
		boolean isPrime = true;

		System.out.print("List all primes from 1 to which number?: ");
		n = scnr.nextInt();

		if (n == 0 || n == 1) {
			System.out.print("The sum of all primes to n is: " + sum);
			System.out.print("\nList of primes from 1 to n: None!");
			return;
		}
		else if (n < 0){
			System.out.print("Given number is negative. Please try again.");
			return;
		}

		System.out.print("List of primes between 1 and n: ");

		for (int i = 2; i <= n; ++i) {
			isPrime = true;
			for (int j = 2; j < i; ++j) {
				if (i % j == 0){
					isPrime = false;
				}
			}

			if (isPrime) {
				System.out.print(i + " ");
				sum += i;
			}
		}

		System.out.print("\n\nThe sum of all primes from 1 to n is: " + sum);
	}
}