package day02_stack_queue_hashmap.hash_maps_hash_functions_problem;

import java.util.*;

class HashMap<K, V> {
    // Define the number of buckets (array size)
    private static final int INITIAL_CAPACITY = 16;

    // Array to store the buckets (linked lists)
    private LinkedList<Entry<K, V>>[] table;

    // Inner class to represent a key-value pair (Entry)
    private static class Entry<K, V> {
        K key;
        V value;

        // Constructor for creating an entry
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash map
    public HashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to map the key to an index in the table
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Insert or update key-value pair in the hash map
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // If key exists, update the value
                entry.value = value;
                return;
            }
        }

        // If the key doesn't exist, add a new entry to the bucket
        bucket.add(new Entry<>(key, value));
    }

    // Retrieve the value associated with the key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Search for the key in the corresponding bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        // If key is not found, return null
        return null;
    }

    // Remove the key-value pair from the hash map
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Search for the key and remove the entry if found
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    // Helper method to check if the hash map is empty
    public boolean isEmpty() {
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (!bucket.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

// Main class to test the custom HashMap
public class MainHashMap {
    public static void main(String[] args) {
        // Create an instance of the custom HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Insert key-value pairs
        map.put("Apple", 5);
        map.put("Banana", 7);
        map.put("Orange", 3);

        // Retrieve values
        System.out.println("Apple: " + map.get("Apple"));   // Output: 5
        System.out.println("Banana: " + map.get("Banana")); // Output: 7

        // Remove a key-value pair
        map.remove("Banana");
        System.out.println("Banana after removal: " + map.get("Banana")); // Output: null

        // Check if the map is empty
        System.out.println("Is the map empty? " + map.isEmpty()); // Output: false
    }
}
