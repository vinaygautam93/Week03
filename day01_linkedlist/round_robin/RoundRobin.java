package day01_linkedlist.round_robin;

class Process {
    int processID, burstTime, priority;
    Process next;

    Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;

    // Add a new process to the end of the list
    void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head; // Make it circular
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove a process by ID
    void removeProcess(int processID) {
        if (head == null) return; // List is empty

        Process temp = head, prev = null;
        do {
            if (temp.processID == processID) {
                if (prev == null) { // Deleting head
                    if (temp.next == head) {
                        head = null; // Single node case
                    } else {
                        Process last = head;
                        while (last.next != head) last = last.next;
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate round-robin scheduling
    void simulate(int timeQuantum) {
        if (head == null) return; // List is empty

        Process current = head;
        while (current != null && head != null) {
            System.out.println("Executing Process: " + current.processID);

            if (current.burstTime <= timeQuantum) {
                System.out.println("Process " + current.processID + " completed.");
                removeProcess(current.processID);
            } else {
                current.burstTime -= timeQuantum;
            }

            current = current.next;
        }
    }

    // Display all processes
    void displayProcesses() {
        if (head == null) return;

        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

// Driver code for Round Robin Scheduling
public class RoundRobin {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);

        System.out.println("Processes in Queue:");
        scheduler.displayProcesses();

        System.out.println("\nSimulating Round Robin with Time Quantum = 4:");
        scheduler.simulate(4);

        System.out.println("\nProcesses Left After Simulation:");
        scheduler.displayProcesses();
    }
}
