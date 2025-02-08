package day05_string_buffer_builder_file;

import java.io.*;

public class ComparePerformance {
    public static void main(String[] args) {
        // Part 1: Compare StringBuilder and StringBuffer
        compareStringBuilderAndBuffer();

        // Part 2: Compare FileReader and InputStreamReader
        compareFileReaders("src/day05_string_buffer_builder_file/sample.txt"); // Update with the path to a large file
    }

    private static void compareStringBuilderAndBuffer() {
        int iterations = 1_000_000;
        String sample = "hello";

        // StringBuilder performance
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sample);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ms");

        // StringBuffer performance
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(sample);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ms");
    }

    private static void compareFileReaders(String filePath) {
        try {
            // FileReader performance
            long startTime = System.currentTimeMillis();
            int wordCount = countWordsWithFileReader(filePath);
            long endTime = System.currentTimeMillis();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (endTime - startTime) + " ms");

            // InputStreamReader performance
            startTime = System.currentTimeMillis();
            wordCount = countWordsWithInputStreamReader(filePath);
            endTime = System.currentTimeMillis();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static int countWordsWithFileReader(String filePath) throws IOException {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Count words in the line
            }
            return wordCount;
        }
    }

    private static int countWordsWithInputStreamReader(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Count words in the line
            }
            return wordCount;
        }
    }
}
