package Module1_CoreJava;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P044_ReadFromOneFileAndWriteContentToAnotherFile {
	public static void main(String[] args) {
        // Source file
        String sourceFile = "source.txt";

        // Destination file
        String destinationFile = "destination.txt";

        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(destinationFile)) {

            // Read and write lines
        	int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
