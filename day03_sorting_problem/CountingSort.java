package day03_sorting_problem;

import java.util.Scanner;
import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range]; // Count array
        int[] output = new int[ages.length]; // Output array

        // Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in the output array in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted ages back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for student ages
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];

        System.out.println("Enter the ages of students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        // Sorting the ages using Counting Sort
        countingSort(ages, 10, 18);

        // Displaying the sorted ages
        System.out.println("Sorted student ages: " + Arrays.toString(ages));
        sc.close();
    }
}
