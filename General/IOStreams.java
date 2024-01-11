import java.io.*;
import java.util.Scanner;

public class IOStreams{
	public static void main(String[] args) throws IOException{
		File filename = new File("../afile.txt");
		FileInputStream fileIn = new FileInputStream(filename);

		Scanner scnr = new Scanner(fileIn);

		while(scnr.hasNextLine())
			System.out.println(scnr.nextLine());

		System.out.println("writing new stuff");

		String newStuff = "This is the new text.";
		FileOutputStream fileOut = new FileOutputStream(filename);
		PrintWriter writer = new PrintWriter(fileOut);
		writer.println(newStuff);
		writer.flush();
		writer.close();
		fileOut.close();
		fileIn.close();
		scnr.close();
		

	}
}