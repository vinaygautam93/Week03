// Node class to represent each student in the linked list
class Student {
    int rollNumber; // Unique identifier for the student
    String name;    // Name of the student
    int age;        // Age of the student
    char grade;     // Grade of the student
    Student next;   // Pointer to the next student in the list

    // Constructor to initialize a new student node
    Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null; // Initially, the next pointer is null
    }
}

// Linked list class for managing student records
class StudentList {
    private Student head; // Pointer to the first student in the list

    // Add a new student at the beginning of the list
    public void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head; // Point the new student's next to the current head
        head = newStudent;      // Update the head to the new student
    }

    // Add a new student at the end of the list
    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent; // If the list is empty, make this student the head
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the last node
        }
        current.next = newStudent; // Update the last node's next pointer
    }

    // Add a new student at a specific position (1-based index)
    public void addStudentAtPosition(int position, int rollNumber, String name, int age, char grade) {
        if (position < 1) {
            System.out.println("Position must be greater than 0.");
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    // Delete a student by roll number
    public void deleteStudent(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next; // Update head if the first student matches
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next; // Traverse to find the student to delete
        }
        if (current.next == null) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
            return;
        }
        current.next = current.next.next; // Remove the node by updating the pointer
    }

    // Search for a student by roll number
    public void searchStudent(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student found: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update a student's grade by roll number
    public void updateGrade(int rollNumber, char newGrade) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade; // Update the grade
                System.out.println("Grade updated for Roll No: " + rollNumber);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
}

// Test the StudentList class
public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();

        // Adding students
        studentList.addStudentAtBeginning(1, "Alice", 20, 'A');
        studentList.addStudentAtEnd(2, "Bob", 22, 'B');
        studentList.addStudentAtPosition(2, 3, "Charlie", 21, 'A');

        // Displaying all students
        System.out.println("All students:");
        studentList.displayAllStudents();

        // Searching for a student
        System.out.println("\nSearching for student with Roll No 2:");
        studentList.searchStudent(2);

        // Updating a student's grade
        System.out.println("\nUpdating grade for Roll No 3:");
        studentList.updateGrade(3, 'B');

        // Deleting a student
        System.out.println("\nDeleting student with Roll No 1:");
        studentList.deleteStudent(1);

        // Displaying all students after deletion
        System.out.println("\nAll students after deletion:");
        studentList.displayAllStudents();
    }
}
