package Module1_CoreJava;

import java.io.BufferedReader;
import java.io.FileReader;

public class P037_ReadFileLinebyLineUsingBufferedReader {
	public static void main(String[] args) {
		String filePath = "FileWrite.txt";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
			String line;
			int lineNumber = 1;
			
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println("Line " + lineNumber + ": " + line);
				lineNumber++;
			}
			System.out.println("File read successfully.");
		} catch (Exception e) {
			// TODO: handle exception
            System.out.println("Error reading file: " + e.getMessage());
		}
	}
}
