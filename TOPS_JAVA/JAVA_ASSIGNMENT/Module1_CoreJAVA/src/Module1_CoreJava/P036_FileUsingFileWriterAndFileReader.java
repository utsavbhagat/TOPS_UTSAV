package Module1_CoreJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class P036_FileUsingFileWriterAndFileReader {
	public static void main(String[] args) {
		try (FileWriter fileWriter = new FileWriter("FileWrite.txt");
				PrintWriter printWriter = new PrintWriter(fileWriter)){
			printWriter.println("Hello Good Morning !!");
			printWriter.println("My Self UTSAV BHAGAT from Jamnagar.");
			printWriter.println("I've done my graducation and post graducation from Saurashtra Univercity in Computer Application");
			printWriter.println("In Addition to my formal education, I'm training as a JAVA devloper from TOPS Technologies PVT. Ltd.");
			printWriter.println("");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error writing to file: "+ e.getMessage());
		}
		
		try (FileReader fileReader = new FileReader("FileWrite.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader))
		{
			String character;
			while ((character = bufferedReader.readLine()) != null) {
				System.out.println(character);
			}
		} catch (IOException e) {
			// TODO: handle exception
	         System.out.println("Error reading from file: " + e.getMessage());

		}
	}
}
