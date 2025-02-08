package day04_linear_binary_search;

import java.util.Scanner;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Input the sorted array
        int[] arr = new int[n];
        System.out.println("Enter the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input the target element
        System.out.println("Enter the target element:");
        int target = scanner.nextInt();

        // Find the first and last occurrence
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        // Output the results
        if (first == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First Occurrence: " + first);
            System.out.println("Last Occurrence: " + last);
        }

        scanner.close();
    }

    // Function to find the first occurrence of the target
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid; // Potential answer
                right = mid - 1; // Continue searching on the left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Function to find the last occurrence of the target
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid; // Potential answer
                left = mid + 1; // Continue searching on the right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
