package day02_stack_queue_hashmap.stack_queue_problem;

import java.util.Stack;
import java.util.Arrays;

class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Remove elements from stack while they are smaller than current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, span is i+1, otherwise it's distance to previous greater element
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i); // Push current index
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);
        System.out.println("Stock spans: " + Arrays.toString(spans));
    }
}
