import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileObj{
	public static void main(String[] args)throws FileNotFoundException, IOException{
		File filename = new File("../afile.txt");

		if (filename.exists()){
			Scanner scnr = new Scanner(filename);
			while (scnr.hasNextLine()){
				System.out.println(scnr.nextLine());
			}
		}

	}
}