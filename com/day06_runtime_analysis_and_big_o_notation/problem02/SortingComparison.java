package com.day06_runtime_analysis_and_big_o_notation.problem02;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort (O(N^2)) - Inefficient for large datasets
    void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N)) - Divide and Conquer approach (Stable)
    void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    // Merge helper function for Merge Sort
    void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort (O(N log N)) - Partition-based approach (Fast but unstable)
    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort the left and right subarrays
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function for Quick Sort
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Dataset sizes to test
        int[] datasetSizes = {1000, 10000, 1000000};

        // Loop through each dataset size for testing
        for (int n : datasetSizes) {
            System.out.println("Testing for dataset size: " + n);

            SortingComparison obj = new SortingComparison();

            // Create a random array of size 'n'
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt();  // Generate random integers
            }

            // Make a copy of the original array to test each algorithm independently
            int[] arrForBubbleSort = Arrays.copyOf(arr, arr.length);
            int[] arrForMergeSort = Arrays.copyOf(arr, arr.length);
            int[] arrForQuickSort = Arrays.copyOf(arr, arr.length);

            // Bubble Sort Test
            long startTime = System.nanoTime();
            obj.bubbleSort(arrForBubbleSort, n);
            long endTime = System.nanoTime();
            long bubbleSortTime = endTime - startTime;
            System.out.println("Bubble Sort Time: " + bubbleSortTime / 1_000_000.0 + " ms");

            // Merge Sort Test
            startTime = System.nanoTime();
            obj.mergeSort(arrForMergeSort);
            endTime = System.nanoTime();
            long mergeSortTime = endTime - startTime;
            System.out.println("Merge Sort Time: " + mergeSortTime / 1_000_000.0 + " ms");

            // Quick Sort Test
            startTime = System.nanoTime();
            obj.quickSort(arrForQuickSort, 0, n - 1);
            endTime = System.nanoTime();
            long quickSortTime = endTime - startTime;
            System.out.println("Quick Sort Time: " + quickSortTime / 1_000_000.0 + " ms");

            // Print separator for readability between test cases
            System.out.println("----------------------------------------------------");
        }
    }
}
