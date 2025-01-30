package day02_stack_queue_hashmap.stack_queue_problem;

import java.util.Stack;

class SortStack {
    // Recursively sorts the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop(); // Remove top element
            sortStack(stack); // Sort remaining stack
            insertInSortedOrder(stack, temp);
        }
    }

    // Inserts an element into the correct position in a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Stack before sorting: " + stack);
        sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
    }
}
