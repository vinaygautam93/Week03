package day04_linear_binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengeProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the list
        System.out.println("Enter the size of the list:");
        int n = scanner.nextInt();

        // Input the list of integers
        int[] arr = new int[n];
        System.out.println("Enter the list of integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input the target value for binary search
        System.out.println("Enter the target value for binary search:");
        int target = scanner.nextInt();

        // Find the first missing positive integer using Linear Search
        int missing = findFirstMissingPositive(arr);
        System.out.println("First Missing Positive Integer: " + missing);

        // Sort the array for binary search
        Arrays.sort(arr);

        // Find the index of the target using Binary Search
        int index = binarySearch(arr, target);
        System.out.println("Index of Target Value: " + (index == -1 ? "Not Found" : index));

        scanner.close();
    }

    // Function to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        // Mark elements as visited by placing them in the correct position
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Function to perform Binary Search to find the index of a target
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
