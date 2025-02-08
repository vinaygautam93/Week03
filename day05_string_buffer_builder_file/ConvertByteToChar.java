package day05_string_buffer_builder_file;

import java.io.*;

public class ConvertByteToChar {
    public static void main(String[] args) {
        // File path
        String filePath = "src/day05_string_buffer_builder_file/sample.txt";

        // Try-with-resources to handle closing resources automatically
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            // Read the file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print the line to the console
            }

        } catch (IOException e) {
            // Handle exceptions such as file not found or encoding issues
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
