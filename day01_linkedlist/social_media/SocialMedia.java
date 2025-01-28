package day01_linkedlist.social_media;

import java.util.HashSet;

class FriendNode {
    int userID;
    String name;
    int age;
    HashSet<Integer> friendIDs; // Store friends as a set of user IDs
    FriendNode next;

    public FriendNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new HashSet<>();
        this.next = null;
    }
}

class SocialMedia {
    private FriendNode head;

    public SocialMedia() {
        head = null;
    }

    // Add a user to the list
    public void addUser(int id, String name, int age) {
        FriendNode newNode = new FriendNode(id, name, age);
        newNode.next = head;
        head = newNode;
    }

    // Add a friend connection between two users
    public void addFriend(int userID1, int userID2) {
        FriendNode user1 = findUser(userID1);
        FriendNode user2 = findUser(userID2);

        if (user1 != null && user2 != null) {
            user1.friendIDs.add(userID2);
            user2.friendIDs.add(userID1);
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        FriendNode user1 = findUser(userID1);
        FriendNode user2 = findUser(userID2);

        if (user1 != null && user2 != null) {
            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
            for (int friendID : user1.friendIDs) {
                if (user2.friendIDs.contains(friendID)) {
                    System.out.println(friendID);
                }
            }
        }
    }

    // Find a user by ID
    public FriendNode findUser(int userID) {
        FriendNode current = head;
        while (current != null) {
            if (current.userID == userID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all friends of a user
    public void displayFriends(int userID) {
        FriendNode user = findUser(userID);
        if (user != null) {
            System.out.println("Friends of " + user.name + ":");
            for (int friendID : user.friendIDs) {
                System.out.println(friendID);
            }
        }
    }

    // Count the number of friends for a user
    public int countFriends(int userID) {
        FriendNode user = findUser(userID);
        if (user != null) {
            return user.friendIDs.size();
        }
        return 0;
    }

    // Main function to test the SocialMedia system
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);

        sm.addFriend(1, 2); // Alice and Bob are friends
        sm.addFriend(1, 3); // Alice and Charlie are friends

        sm.displayFriends(1); // Display Alice's friends
        sm.findMutualFriends(1, 2); // Find mutual friends between Alice and Bob

        System.out.println("Number of friends of Alice: " + sm.countFriends(1));
    }
}
