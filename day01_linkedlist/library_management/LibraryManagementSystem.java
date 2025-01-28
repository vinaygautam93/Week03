package day01_linkedlist.library_management;

// Node class for the doubly linked list
class Book {
    String title, author, genre;
    int bookID;
    boolean isAvailable;
    Book next, prev;

    Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// Doubly linked list for Library Management
class Library {
    private Book head, tail;

    // Add a new book at the beginning
    void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook; // List is empty
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a new book at the end
    void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook; // List is empty
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Remove a book by Book ID
    void removeBookByID(int bookID) {
        if (head == null) return; // List is empty
        Book temp = head;

        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }

        if (temp == null) return; // Book not found

        if (temp == head) head = head.next; // Removing head
        if (temp == tail) tail = tail.prev; // Removing tail
        if (temp.prev != null) temp.prev.next = temp.next; // Adjust prev link
        if (temp.next != null) temp.next.prev = temp.prev; // Adjust next link
    }

    // Search for a book by Title or Author
    void searchBook(String query) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No matching book found.");
    }

    // Display all books in forward order
    void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("[" + temp.bookID + "] " + temp.title + " by " + temp.author);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("[" + temp.bookID + "] " + temp.title + " by " + temp.author);
            temp = temp.prev;
        }
    }

    // Count total books
    int countBooks() {
        Book temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

// Driver code for Library Management
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtBeginning("Harry Potter", "J.K. Rowling", "Fantasy", 1, true);
        library.addBookAtEnd("The Hobbit", "J.R.R. Tolkien", "Adventure", 2, true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 3, false);

        System.out.println("Books in Forward Order:");
        library.displayForward();

        System.out.println("\nBooks in Reverse Order:");
        library.displayReverse();

        System.out.println("\nSearching for '1984':");
        library.searchBook("1984");

        System.out.println("\nRemoving Book with ID 2:");
        library.removeBookByID(2);

        System.out.println("\nBooks in Forward Order after Removal:");
        library.displayForward();

        System.out.println("\nTotal Books: " + library.countBooks());
    }
}
