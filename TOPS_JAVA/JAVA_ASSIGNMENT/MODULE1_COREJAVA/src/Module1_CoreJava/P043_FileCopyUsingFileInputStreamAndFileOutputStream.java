package Module1_CoreJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P043_FileCopyUsingFileInputStreamAndFileOutputStream {
	public static void main(String[]args) {
		// Source file
        String sourceFile = "source.txt";

        // Destination file
        String destinationFile = "destination.txt";

        // Copy file
         copyFile(sourceFile, destinationFile);
	}
	public static void copyFile(String sourceFile, String destinationFile) {
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {

            // Read and write bytes
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
	
}
