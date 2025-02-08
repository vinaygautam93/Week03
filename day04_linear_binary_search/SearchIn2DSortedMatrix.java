package day04_linear_binary_search;

import java.util.Scanner;

public class SearchIn2DSortedMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of rows and columns in the matrix
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();

        // Input the matrix
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Input the target value to search for
        System.out.println("Enter the target value to search:");
        int target = scanner.nextInt();

        // Perform the binary search and print the result
        boolean result = searchMatrix(matrix, target);
        System.out.println(result ? "True" : "False");

        scanner.close();
    }

    // Function to perform binary search in a 2D sorted matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            // Find the middle index
            int mid = left + (right - left) / 2;

            // Convert the 1D index back to row and column
            int row = mid / cols;
            int col = mid % cols;

            // Compare the middle element with the target
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        // If the loop completes without finding the target
        return false;
    }
}

