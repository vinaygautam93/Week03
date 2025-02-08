package day04_linear_binary_search;

import java.util.Scanner;

public class RotationPointSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Input the rotated sorted array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find the rotation point
        int result = findRotationPoint(arr);

        // Print the result
        System.out.println(result);

        scanner.close();
    }

    // Function to find the index of the smallest element in a rotated sorted array
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the last element, rotation point is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Otherwise, it's in the left half (including mid)
                right = mid;
            }
        }
        return left; // The left pointer points to the rotation point
    }
}
