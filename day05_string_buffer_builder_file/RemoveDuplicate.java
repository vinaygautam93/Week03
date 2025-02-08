package day05_string_buffer_builder_file;

import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input a string
        System.out.println("Enter a string to remove duplicates:");
        String input = scanner.nextLine();  // Read the input string

        // Initialize a StringBuilder to hold the result (string without duplicates)
        StringBuilder sb = new StringBuilder();

        // Use a HashSet to keep track of characters we've already seen
        HashSet<Character> seen = new HashSet<>();

        // Loop over each character in the input string
        for (char c : input.toCharArray()) {
            // If this character hasn't been seen before, add it to the result string
            if (!seen.contains(c)) {
                sb.append(c);  // Add the character to the StringBuilder
                seen.add(c);   // Mark this character as seen
            }
        }

        // Print the final string without duplicates
        System.out.println("String after removing duplicates: " + sb);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
