package day02_stack_queue_hashmap.hash_maps_hash_functions_problem;

import java.util.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class Solution1 {
    public int longestConsecutive(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // If the array is empty, return 0 since there are no consecutive sequences
        if (n == 0) return 0;

        // Create a map to store the frequency of each number in the array
        Map<Integer, Integer> mp = new HashMap<>();

        // Loop through the array to populate the map with the numbers
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);  // Update frequency of each number
        }

        // Create a list from the keys of the map, which are the unique numbers in the array
        List<Integer> temNum = new ArrayList<>(mp.keySet());

        // Sort the list of unique numbers to process them in ascending order
        Collections.sort(temNum);

        // Variables to track the length of the current consecutive sequence and the longest one
        int totalSeq = 0;
        int temp = 0;
        int sz = temNum.size();

        // Iterate through the sorted list of unique numbers
        for (int i = 0; i < sz - 1; i++) {
            // Check if the next number is exactly 1 greater than the current number
            // If true, this means the numbers are consecutive
            if (temNum.get(i) + 1 == temNum.get(i + 1)) {
                temp++;  // Increase the current sequence length
            } else {
                temp = 0;  // Reset the current sequence length if numbers are not consecutive
            }
            // Keep track of the maximum sequence length encountered so far
            totalSeq = Math.max(totalSeq, temp);
        }

        // The total sequence length is 1 plus the length of the longest consecutive sequence
        return totalSeq + 1;
    }

    // Main method to take user input and test the solution
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        Scanner scanner = new Scanner(System.in);

        // Ask for the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Create an array to hold the user's input
        int[] nums = new int[n];

        // Take user input for the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Call the method and display the result
        int result = solution.longestConsecutive(nums);
        System.out.println("The length of the longest consecutive sequence is: " + result);

        scanner.close();
    }
}
