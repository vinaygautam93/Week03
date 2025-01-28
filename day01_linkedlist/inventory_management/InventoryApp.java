package day01_linkedlist.inventory_management;

// Class representing a node in the singly linked list
class InventoryItem {
    String itemName;  // Name of the item
    int itemId;       // ID of the item
    int quantity;     // Quantity of the item
    double price;     // Price of the item
    InventoryItem next; // Pointer to the next item

    // Constructor to initialize an inventory item
    public InventoryItem(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Inventory Management System using a singly linked list
class InventoryManager {
    private InventoryItem head = null; // Pointer to the head of the list

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at the beginning: " + itemName);
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            InventoryItem current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
        System.out.println("Item added at the end: " + itemName);
    }

    // Add an item at a specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position <= 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        InventoryItem current = head;
        int index = 0;

        while (index < position - 1 && current != null) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Position out of range. Adding item at the end.");
            addItemAtEnd(itemName, itemId, quantity, price);
        } else {
            newItem.next = current.next;
            current.next = newItem;
            System.out.println("Item added at position " + position + ": " + itemName);
        }
    }

    // Remove an item by Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("No items to remove.");
            return;
        }

        if (head.itemId == itemId) {
            System.out.println("Item removed: " + head.itemName);
            head = head.next;
            return;
        }

        InventoryItem current = head, prev = null;
        while (current != null && current.itemId != itemId) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            prev.next = current.next;
            System.out.println("Item removed: " + current.itemName);
        }
    }

    // Update the quantity of an item by Item ID
    public void updateItemQuantity(int itemId, int newQuantity) {
        InventoryItem current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Item updated: " + current.itemName + " (New Quantity: " + newQuantity + ")");
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(int itemId, String itemName) {
        InventoryItem current = head;
        boolean found = false;

        while (current != null) {
            if (current.itemId == itemId || current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + current.itemName + " (ID: " + current.itemId +
                        ", Quantity: " + current.quantity + ", Price: " + current.price + ")");
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No item found with ID: " + itemId + " or Name: " + itemName);
        }
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        InventoryItem current = head;

        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }

        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Sort the inventory by Item Name in ascending order
    public void sortInventoryByName() {
        if (head == null || head.next == null) {
            return; // No sorting needed for empty or single-item list
        }

        boolean swapped;
        do {
            swapped = false;
            InventoryItem current = head;
            while (current.next != null) {
                if (current.itemName.compareToIgnoreCase(current.next.itemName) > 0) {
                    // Swap nodes' data
                    String tempName = current.itemName;
                    int tempId = current.itemId;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;

                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;

                    current.next.itemName = tempName;
                    current.next.itemId = tempId;
                    current.next.quantity = tempQuantity;
                    current.next.price = tempPrice;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("Inventory sorted by Item Name.");
    }

    // Display all items in the inventory
    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }

        InventoryItem current = head;
        System.out.println("Inventory Items:");
        while (current != null) {
            System.out.println("Name: " + current.itemName + ", ID: " + current.itemId +
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}

// Main class to test the Inventory Management System
public class InventoryApp {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Add items
        manager.addItemAtBeginning("Laptop", 101, 5, 75000);
        manager.addItemAtEnd("Mouse", 102, 50, 500);
        manager.addItemAtPosition("Keyboard", 103, 30, 1500, 1);

        // Display items
        manager.displayAllItems();

        // Search for an item
        manager.searchItem(102, "Mouse");

        // Update item quantity
        manager.updateItemQuantity(101, 10);

        // Calculate total value
        manager.calculateTotalValue();

        // Sort items by name
        manager.sortInventoryByName();

        // Display sorted items
        manager.displayAllItems();

        // Remove an item
        manager.removeItemById(103);

        // Display items after removal
        manager.displayAllItems();
    }
}
