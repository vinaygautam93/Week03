package day05_string_buffer_builder_file;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // File path
        String filePath = "src/day05_string_buffer_builder_file/sample.txt";

        // Try-with-resources for efficient resource management
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath)) {

            System.out.println("Enter text to write to the file (type 'exit' to quit):");

            String input;
            // Continuously read input from the user
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(input + System.lineSeparator()); // Write each input line to the file
            }

            System.out.println("Data successfully written to " + filePath);

        } catch (IOException e) {
            // Handle any IO exceptions
            System.err.println("Error during input or output: " + e.getMessage());
        }
    }
}

