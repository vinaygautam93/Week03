package com.day06_runtime_analysis_and_big_o_notation.problem04;

import java.io.*;
import java.util.Random;

public class FileReadBenchmark {

    // Generate a test file with a specified size in MB
    static void generateTestFile(String filePath, int sizeInMB) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] buffer = new byte[1024 * 1024]; // 1MB buffer
            Random random = new Random();

            for (int i = 0; i < sizeInMB; i++) {
                random.nextBytes(buffer);
                bos.write(buffer);
            }
            System.out.println("File generated: " + filePath + " (" + sizeInMB + "MB)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read file using FileReader
    static long readUsingFileReader(String filePath) {
        long startTime = System.nanoTime();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {
                // Reads character by character (slow)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (System.nanoTime() - startTime) / 1_000_000; // Convert to milliseconds
    }

    // Read file using InputStreamReader
    static long readUsingInputStreamReader(String filePath) {
        long startTime = System.nanoTime();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {
                // Reads bytes and converts into characters (faster)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (System.nanoTime() - startTime) / 1_000_000; // Convert to milliseconds
    }

    public static void main(String[] args) {
        // Define file names for different sizes
        String[] filePaths = {"large_file_1MB.txt", "large_file_100MB.txt", "large_file_500MB.txt"};
        int[] sizesInMB = {1, 100, 500}; // Corresponding sizes in MB

        for (int i = 0; i < sizesInMB.length; i++) {
            String filePath = filePaths[i];

            // Generate separate files for each size
            generateTestFile(filePath, sizesInMB[i]);

            // Measure FileReader performance
            long fileReaderTime = readUsingFileReader(filePath);
            System.out.println("FileReader Time for " + filePath + ": " + fileReaderTime + " ms");

            // Measure InputStreamReader performance
            long inputStreamReaderTime = readUsingInputStreamReader(filePath);
            System.out.println("InputStreamReader Time for " + filePath + ": " + inputStreamReaderTime + " ms");

            System.out.println("----------------------------------------------------");
        }
    }
}
