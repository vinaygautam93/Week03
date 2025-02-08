package day05_string_buffer_builder_file;

public class CompareStr {
    public static void main(String[] args) {
        // Set the number of repetitions for concatenation
        int repetitions = 1000000;
        String str = "hello";

        // Measure the time for StringBuffer concatenation
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < repetitions; i++) {
            sb.append(str);  // Append the string to the buffer
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        // Measure the time for StringBuilder concatenation
        startTime = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            sbuilder.append(str);  // Append the string to the builder
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        // Output the results
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " nanoseconds");

        // Compare the times
        if (stringBufferTime < stringBuilderTime) {
            System.out.println("StringBuffer is faster.");
        } else {
            System.out.println("StringBuilder is faster.");
        }
    }
}
