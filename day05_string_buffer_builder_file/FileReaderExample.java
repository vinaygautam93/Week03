package day05_string_buffer_builder_file;

import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        // File path
        String filePath = "src/day05_string_buffer_builder_file/sample.txt";


        // Try-with-resources ensures the file is automatically closed after reading
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            // Read each line until there are no more lines (null)
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print the line to the console
            }

        } catch (IOException e) {
            // Handle exceptions (e.g., file not found or read error)
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
