package day03_sorting_problem;

import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] empIds) {
        int n = empIds.length;

        // Traverse from the second element to the last
        for (int i = 1; i < n; i++) {
            int key = empIds[i]; // Pick an element from the unsorted part
            int j = i - 1;

            // Move elements of sorted part that are greater than key one position ahead
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }
            empIds[j + 1] = key; // Insert key at its correct position
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for employee IDs
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        int[] empIds = new int[n];

        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            empIds[i] = sc.nextInt();
        }

        // Sorting the employee IDs using Insertion Sort
        insertionSort(empIds);

        // Displaying the sorted employee IDs
        System.out.println("Sorted employee IDs: " + Arrays.toString(empIds));
        sc.close();
    }
}
