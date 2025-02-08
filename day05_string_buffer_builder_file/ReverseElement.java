package day05_string_buffer_builder_file;

import java.util.Scanner;

public class ReverseElement {
    public static void main(String[] args) {
        // Creating a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input a string
        System.out.println("Enter a string to reverse:");
        String input = scanner.nextLine();  // Read the input string

        // Create a StringBuilder to work with the input string
        StringBuilder sb = new StringBuilder(input);

        // Reverse the string using StringBuilder's built-in reverse method
        sb.reverse();

        // Convert the StringBuilder back to a string and print the reversed string
        System.out.println("Reversed string: " + sb);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
