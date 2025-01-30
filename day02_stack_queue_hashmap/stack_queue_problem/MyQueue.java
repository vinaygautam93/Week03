package day02_stack_queue_hashmap.stack_queue_problem;

import java.util.Stack;
import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack = new Stack<>();  // Stack for enqueue operations
    Stack<Integer> outStack = new Stack<>(); // Stack for dequeue operations

    // Enqueue operation (push into inStack)
    public void enqueue(int x) {
        inStack.push(x);
    }

    // Dequeue operation (pop from outStack, refill if empty)
    public int dequeue() {
        if (outStack.isEmpty()) {
            // Move elements from inStack to outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.isEmpty() ? -1 : outStack.pop(); // Return -1 if queue is empty
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // Expected: 1
        System.out.println(queue.dequeue()); // Expected: 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // Expected: 3
    }
}
