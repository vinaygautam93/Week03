package com.day06_runtime_analysis_and_big_o_notation.problem01;

import java.util.Arrays;
import java.util.Random;

public class SearchTarget {

    // Method for linear search to find the target in the array
    void linearSearchTimeFind(int arr[], int n, int target) {
        // Traverse the array and search for the target
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                break; // Stop searching once the target is found
            }
        }
    }

    // Method for binary search to find the target in the sorted array
    void binarySearchTimeFind(int arr[], int n, int target) {
        int first = 0;
        int end = n - 1;  // Correct initialization of 'end'

        while (first <= end) {  // Loop until the search space is valid
            int mid = first + (end - first) / 2; // Calculate middle index

            if (arr[mid] == target) {
                break; // Target found, break out of the loop
            } else if (arr[mid] < target) {
                first = mid + 1; // Narrow down the search space to the right half
            } else {
                end = mid - 1; // Narrow down the search space to the left half
            }
        }
    }

    public static void main(String[] args) {

        // Random object for generating random numbers
        Random random = new Random();

        // Dataset sizes to be tested
        int[] datasetSizes = {1000, 10000, 1000000};

        // Loop through each dataset size for testing
        for (int n : datasetSizes) {
            System.out.println("Testing for dataset size: " + n);

            // Create an object of SearchTarget class to call the search methods
            SearchTarget obj = new SearchTarget();

            // Randomly generate the target value to search for
            int target = random.nextInt();

            // Create an array of size 'n' and populate it with random values
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Math.abs(random.nextInt()); // Using Math.abs to avoid negative numbers
            }

            // Measure the time taken by linear search
            long startTime = System.nanoTime();
            obj.linearSearchTimeFind(arr, n, target);  // Call linear search method
            long endTime = System.nanoTime();
            long linearSearchTime = endTime - startTime; // Calculate time taken by linear search

            // Print the time taken for linear search
            System.out.println("Linear Search Time: " + linearSearchTime / 1_000_000.0 + " ms");

            // Sort the array before performing binary search (binary search requires sorted array)
            Arrays.sort(arr);

            // Measure the time taken by binary search
            startTime = System.nanoTime();
            obj.binarySearchTimeFind(arr, n, target);  // Call binary search method
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime; // Calculate time taken by binary search

            // Print the time taken for binary search
            System.out.println("Binary Search Time: " + binarySearchTime / 1_000_000.0 + " ms");

            // Print a separator for better readability between test cases
            System.out.println("----------------------------------------------------");
        }
    }
}
