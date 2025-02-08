package day04_linear_binary_search;

import java.util.Scanner;

public class FirstNegativeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Input the array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find the first negative number
        int result = findFirstNegativeIndex(arr);

        // Print the result
        System.out.println(result);

        scanner.close();
    }

    // Function to find the index of the first negative number in the array
    public static int findFirstNegativeIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return the index of the first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }
}
