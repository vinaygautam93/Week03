package day01_linkedlist.task_scheduler;

// Class representing a node in the circular linked list
class Task {
    int taskId;          // Task ID
    String taskName;     // Task name
    int priority;        // Task priority
    String dueDate;      // Due date of the task
    Task next;           // Pointer to the next task (circular)

    // Constructor to initialize a task node
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Task scheduler using a circular linked list
class TaskScheduler {
    private Task head = null;  // Pointer to the head of the circular list
    private Task tail = null;  // Pointer to the tail of the circular list

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Circular link
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Maintain circular structure
        }
        System.out.println("Task added at the beginning: " + taskName);
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = newTask;
            tail.next = head; // Circular link
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Maintain circular structure
        }
        System.out.println("Task added at the end: " + taskName);
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task current = head;
        int index = 0;

        while (index < position - 1 && current.next != head) {
            current = current.next;
            index++;
        }

        newTask.next = current.next;
        current.next = newTask;
        if (current == tail) {
            tail = newTask;
        }
        System.out.println("Task added at position " + position + ": " + taskName);
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task current = head, prev = null;
        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Task removed: " + current.taskName);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task not found with ID: " + taskId);
    }

    // View the current task and move to the next task
    public void viewAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }

        System.out.println("Current Task: " + head.taskName);
        head = head.next; // Move to the next task (circular)
    }

    // Display all tasks starting from the head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task current = head;
        System.out.println("Tasks in the scheduler:");
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task current = head;
        boolean found = false;

        do {
            if (current.priority == priority) {
                System.out.println("Found Task: " + current.taskName + " (Priority: " + priority + ")");
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with Priority: " + priority);
        }
    }
}

// Main class to test the Task Scheduler
public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        scheduler.addTaskAtBeginning(1, "Task A", 3, "2025-02-01");
        scheduler.addTaskAtEnd(2, "Task B", 2, "2025-02-15");
        scheduler.addTaskAtPosition(3, "Task C", 1, "2025-02-10", 1);

        // Display tasks
        scheduler.displayAllTasks();

        // View and move to next task
        scheduler.viewAndMoveNext();
        scheduler.viewAndMoveNext();

        // Search tasks by priority
        scheduler.searchTaskByPriority(2);

        // Remove a task
        scheduler.removeTaskById(2);

        // Display all tasks again
        scheduler.displayAllTasks();
    }
}
