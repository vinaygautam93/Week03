package day05_string_buffer_builder_file;

import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        // File path
        String filePath = "src/day05_string_buffer_builder_file/sample.txt";
        String targetWord = "Java"; // Word to count occurrences of (case-sensitive)

        int count = 0; // Counter for occurrences

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split the line into words based on spaces and punctuation
                String[] words = line.split("\\s+");

                // Check each word in the line
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++; // Increment count if word matches
                    }
                }
            }

            // Display the total count of occurrences
            System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");

        } catch (IOException e) {
            // Handle file read errors
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
