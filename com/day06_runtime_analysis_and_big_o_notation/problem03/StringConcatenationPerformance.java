package com.day06_runtime_analysis_and_big_o_notation.problem03;

public class StringConcatenationPerformance {

    // Method to concatenate strings using String (O(N^2))
    void stringConcatenation(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "string"; // Concatenation creates a new String object every time (inefficient)
        }
    }

    // Method to concatenate strings using StringBuilder (O(N))
    void stringBuilderConcatenation(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("string"); // Efficient because StringBuilder is mutable
        }
    }

    // Method to concatenate strings using StringBuffer (O(N))
    void stringBufferConcatenation(int n) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < n; i++) {
            result.append("string"); // Similar to StringBuilder but thread-safe
        }
    }

    public static void main(String[] args) {
        // Dataset sizes to test
        int[] datasetSizes = {1000, 10000, 1000000};

        // Loop through each dataset size for testing
        for (int n : datasetSizes) {
            System.out.println("Testing for dataset size: " + n);

            StringConcatenationPerformance obj = new StringConcatenationPerformance();

            // Test String concatenation
            long startTime = System.nanoTime();
            obj.stringConcatenation(n);
            long endTime = System.nanoTime();
            long stringConcatenationTime = endTime - startTime;
            System.out.println("String Concatenation Time: " + stringConcatenationTime / 1_000_000.0 + " ms");

            // Test StringBuilder concatenation
            startTime = System.nanoTime();
            obj.stringBuilderConcatenation(n);
            endTime = System.nanoTime();
            long stringBuilderConcatenationTime = endTime - startTime;
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderConcatenationTime / 1_000_000.0 + " ms");

            // Test StringBuffer concatenation
            startTime = System.nanoTime();
            obj.stringBufferConcatenation(n);
            endTime = System.nanoTime();
            long stringBufferConcatenationTime = endTime - startTime;
            System.out.println("StringBuffer Concatenation Time: " + stringBufferConcatenationTime / 1_000_000.0 + " ms");

            // Print separator for readability between test cases
            System.out.println("----------------------------------------------------");
        }
    }
}
