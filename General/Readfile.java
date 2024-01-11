import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Readfile{
	public static void main(String[] args) throws FileNotFoundException, IOException{
		FileReader file = new FileReader("../afile.txt");
		BufferedReader fileBuffer = new BufferedReader(file);
		String line = fileBuffer.readLine();
		while (line != null){
			System.out.println(line);
			line = fileBuffer.readLine();
		}
	}
}