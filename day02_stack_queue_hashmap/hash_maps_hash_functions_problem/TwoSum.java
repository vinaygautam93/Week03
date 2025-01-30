package day02_stack_queue_hashmap.hash_maps_hash_functions_problem;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the number and its index as we iterate through the array
        HashMap<Integer, Integer> numMap = new HashMap<>();

        // Loop through the array of numbers
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement we need to find in the map
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                // If found, return the indices: the current index and the index of the complement
                return new int[]{numMap.get(complement), i};
            }

            // If the complement is not found, store the current number and its index in the map
            numMap.put(nums[i], i);
        }

        // Return an empty array if no solution is found (though the problem guarantees a solution)
        return new int[]{};
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        // Printing the result, which should be the indices of the two numbers that sum up to the target
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}

