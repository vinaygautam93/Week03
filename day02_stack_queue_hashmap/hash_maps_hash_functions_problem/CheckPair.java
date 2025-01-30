package day02_stack_queue_hashmap.hash_maps_hash_functions_problem;
import java.util.*;

import java.util.HashSet;

public class CheckPair {
    public static boolean hasPairWithSum(int[] arr, int target) {
        // HashSet to store numbers we have seen so far
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through the array
        for (int num : arr) {
            // Check if (target - num) is already in the set
            if (seen.contains(target - num)) {
                return true; // Found a pair that adds up to the target
            }
            // Store the current number in the set
            seen.add(num);
        }

        // No pair found
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7}; // Sample array
        int target = 17; // Target sum we need to check

        // Call function and print result
        System.out.println(hasPairWithSum(arr, target)); // Output: true (10 + 7)
    }
}
