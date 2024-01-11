import java.util.Scanner;

public class OutputRedir{
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		System.out.print("Type something: ");

		String something = scnr.nextLine();
		System.out.print(something);
	}
}