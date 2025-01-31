package day03_sorting_problem;

import java.util.Scanner;
import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // Move boundary of unsorted array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the first element is the minimum

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for exam scores
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        int[] scores = new int[n];

        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Sorting exam scores using Selection Sort
        selectionSort(scores);

        // Displaying the sorted scores
        System.out.println("Sorted exam scores: " + Arrays.toString(scores));
        sc.close();
    }
}

