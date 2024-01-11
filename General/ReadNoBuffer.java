import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadNoBuffer{
	public static void main(String[] args) throws FileNotFoundException, IOException{
		FileReader file = new FileReader("afile.txt");
		int line = file.read();
		while (line != -1){
			System.out.println(line);
			line = file.read();
		}
	}
}