package day03_sorting_problem;

import java.util.Scanner;
import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Assume root is the largest
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for salary demands
        System.out.print("Enter the number of job applicants: ");
        int n = sc.nextInt();
        int[] salaries = new int[n];

        System.out.println("Enter the salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }

        // Sorting the salary demands using Heap Sort
        heapSort(salaries);

        // Displaying the sorted salaries
        System.out.println("Sorted salary demands: " + Arrays.toString(salaries));
        sc.close();
    }
}
