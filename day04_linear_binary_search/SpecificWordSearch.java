package day04_linear_binary_search;

import java.util.Scanner;

public class SpecificWordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of sentences
        System.out.println("Enter the number of sentences:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Input the sentences
        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        // Input the word to search for
        System.out.println("Enter the word to search:");
        String word = scanner.nextLine();

        // Perform the search
        String result = findSentenceWithWord(sentences, word);

        // Print the result
        System.out.println(result);

        scanner.close();
    }

    // Function to search for the first sentence containing a specific word
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            // Check if the sentence contains the word
            if (sentence.contains(word)) {
                return sentence; // Return the sentence if the word is found
            }
        }
        return "Not Found"; // Return "Not Found" if no sentence contains the word
    }
}
