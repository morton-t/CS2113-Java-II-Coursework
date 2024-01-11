import java.util.Scanner;

/*
This program prompts the user to input a password and stores it as a String, which is then passed to validate().
validate() checks the length of the password, whether it is alphanumeric, and if it contains illegal characters or consecutive numbers.
If these conditions are met, validate() checks for a capital letter and a number in the password and returns true. The user is informed their password is accepted.
If any of these conditions are invalid, validate() returns false and the user is prompted to enter their password choice again.
*/


public class Morton_Problem5{
	public static boolean validate(String password) {
		boolean hasNum = false;
		boolean hasUpper = false;
		boolean hasSpace = false;

		//Before proceeding, validate if the password is a valid length
		if (!(password.length() >= 6 && password.length() <= 8)) { 
			return false;
			
		}

		//Iterate through the characters of the password & check for disqualifying criteria	
		for (int i = 0; i < password.length(); ++i){
			//Verifies the password does not contain whitespace characters
			//I know this is redudant due to the following clause, but it was mentioned in the assignment description
			if (password.charAt(i) == ' ' || password.charAt(i) == '\t'){
				return false;
			}
		
			//Checks for only numbers & letters in password
			//returns false if non-alphanumeric characters exist
			if (!((password.charAt(i) >= 48 && password.charAt(i) <= 57) || 
				(password.charAt(i) >= 65 && password.charAt(i) <= 90) ||
				(password.charAt(i) >= 97 && password.charAt(i) <= 122))){
				return false;
			}

			//Verify the password contains a number
			if (password.charAt(i) >= 48 && password.charAt(i) <= 57){ 
				hasNum = true;

				if (i > 0){
					//Checks the previous character for a numeric value
					//If it is numeric as well, returns false
					if (password.charAt(i - 1) >= 48 && password.charAt(i - 1) <= 57){  											
						return false;
					}
				}
			}
				
			//Verifies if the password has a capital letter
			if (password.charAt(i) >= 65 && password.charAt(i) <= 90){	
				hasUpper = true;
			}
		}

		//If execution made it this far, returns true if password contains a number and a capital letter
		if (hasNum && hasUpper) {
			return true;
		}

		return false;
	}

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		boolean validPass = false;

		//Prompts the user to enter a valid password until one is entered
		while (!validPass) {
			System.out.print("Enter a password: ");
			String password = scnr.nextLine();

			validPass = validate(password);

			if (validPass){
				System.out.println("Your password was accepted.");
			}
			else {
				System.out.println("Invalid password!\n");
			}
		}
	}
}