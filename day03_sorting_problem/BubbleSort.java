package day03_sorting_problem;

import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Traverse through the array multiple times
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if needed
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps were made, the array is already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for student marks
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        int[] marks = new int[n];

        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        // Sorting the marks using Bubble Sort
        bubbleSort(marks);

        // Displaying the sorted marks
        System.out.println("Sorted marks: " + Arrays.toString(marks));
        sc.close();
    }
}
