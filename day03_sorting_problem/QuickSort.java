package day03_sorting_problem;

import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);

            // Recursively apply Quick Sort to partitions
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        // Swap pivot into correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for product prices
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Sorting the product prices using Quick Sort
        quickSort(prices, 0, n - 1);

        // Displaying the sorted prices
        System.out.println("Sorted product prices: " + Arrays.toString(prices));
        sc.close();
    }
}

