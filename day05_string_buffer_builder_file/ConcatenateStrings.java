package day05_string_buffer_builder_file;

import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {
        // Create a scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of strings they want to concatenate
        System.out.println("Enter the number of strings you want to concatenate:");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Create an array to store the strings
        String[] strings = new String[n];

        // Ask the user to input the strings one by one
        System.out.println("Enter the strings:");

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        // Create a StringBuffer to hold the concatenated result
        StringBuffer sb = new StringBuffer();

        // Loop through the array and append each string to the StringBuffer
        for (String str : strings) {
            sb.append(str);  // Efficiently append each string to the buffer
        }

        // Output the concatenated string
        System.out.println("Concatenated string: " + sb);


    }
}
