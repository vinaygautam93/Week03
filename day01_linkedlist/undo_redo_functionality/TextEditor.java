package day01_linkedlist.undo_redo_functionality;

class TextState {
    String text;
    TextState prev;
    TextState next;

    public TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState currentState;
    private TextState head;
    private TextState tail;
    private int historyLimit;
    private int historyCount;

    public TextEditor(int limit) {
        this.head = null;
        this.tail = null;
        this.currentState = null;
        this.historyLimit = limit;
        this.historyCount = 0;
    }

    // Add a new state to the history
    public void addState(String newText) {
        TextState newState = new TextState(newText);

        // If there's a current state, link it to the new state
        if (currentState != null) {
            currentState.next = newState;
            newState.prev = currentState;
        }

        currentState = newState;

        // If history exceeds the limit, remove the oldest state (head)
        if (historyCount == historyLimit) {
            TextState temp = head;
            head = head.next;
            deleteNode(temp);
        } else {
            historyCount++;
        }

        // Update the tail pointer to the newest state
        if (tail == null) {
            head = tail = currentState;
        } else {
            tail = currentState;
        }
    }

    // Undo the last action (revert to the previous state)
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.text);
        } else {
            System.out.println("No more undo operations.");
        }
    }

    // Redo the last undone action (revert back to the next state)
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.text);
        } else {
            System.out.println("No more redo operations.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current text: " + currentState.text);
        } else {
            System.out.println("No text available.");
        }
    }

    // Helper function to delete a node (for memory management)
    private void deleteNode(TextState node) {
        if (node != null) {
            node.prev = null;
            node.next = null;
        }
    }

    // Main function to test the TextEditor with undo/redo functionality
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello, world!");
        editor.addState("Hello, world! How are you?");

        editor.displayCurrentState();

        editor.undo(); // Undo last action
        editor.undo(); // Undo again

        editor.redo(); // Redo last undone action
    }
}
