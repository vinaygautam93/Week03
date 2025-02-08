package day04_linear_binary_search;

import java.util.Scanner;

public class PeakElementSearch {
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

        // Find a peak element
        int result = findPeakElement(arr);

        // Print the result
        System.out.println(result);

        scanner.close();
    }

    // Function to find a peak element in the array
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is less than its next neighbor, the peak lies in the right half
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // Otherwise, it lies in the left half (including mid)
                right = mid;
            }
        }
        return left; // The left pointer points to a peak element
    }
}
