package day02_stack_queue_hashmap.stack_queue_problem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store maximum of each window
        Deque<Integer> deque = new LinkedList<>(); // Stores indices of useful elements

        for (int i = 0; i < n; i++) {
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements smaller than the current one (they won’t be useful)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i); // Add current index

            // Store result when we have processed at least 'k' elements
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximums: " + Arrays.toString(result));
    }
}
