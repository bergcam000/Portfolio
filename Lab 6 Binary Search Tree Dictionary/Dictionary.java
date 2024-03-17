// Cameron Berg
// Class: CS&145
// Date 3/10/2024
// Lab 6 Binary Search Tree Dictionary
// Purpose: This program is designed to create a binary search tree
// THIS IS A BST

import java.util.Scanner;

class Dictionary {
    static class Node {
        String key;
        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        String zip;
        String email;
        String phone;
        Node left, right;

        // Constructor to initialize a node with provided data
        public Node(String key, String firstName, String lastName, String address, String city, 
        String state, String zip, String email, String phone) {
            this.key = key;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.email = email;
            this.phone = phone;
            left = right = null;
        }
    }

    Node root;

    // Constructor to initialize an empty dictionary
    public Dictionary() {
        root = null;
    }

    // Method to add an entry to the dictionary
    void addEntry(String key, String firstName, String lastName, String address,
     String city, String state, String zip, String email, String phone) {
        root = addRec(root, key, firstName, lastName, address, city, state, zip, email, phone);
    }

    // Recursive helper method to add an entry to the dictionary
    private Node addRec(Node root, String key, String firstName, String lastName, String address,
     String city, String state, String zip, String email, String phone) {
        if (root == null) {
            root = new Node(key, firstName, lastName, address, city, state, zip, email, phone);
            return root;
        }

        if (key.compareTo(root.key) < 0)
            root.left = addRec(root.left, key, firstName, lastName,
             address, city, state, zip, email, phone);
        else if (key.compareTo(root.key) > 0)
            root.right = addRec(root.right, key, firstName,
             lastName, address, city, state, zip, email, phone);

        return root;
    }

    // Method to perform an in-order traversal of the dictionary and print entries
    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            printEntry(root);
            inorderTraversal(root.right);
        }
    }

    // Method to perform a pre-order traversal of the dictionary and print entries
    void preorderTraversal(Node root) {
        if (root != null) {
            printEntry(root);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Method to perform a post-order traversal of the dictionary and print entries
    void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            printEntry(root);
        }
    }

    // Method to print the details of a node
    void printEntry(Node node) {
        System.out.println("Key: " + node.key);
        System.out.println("Name: " + node.firstName + " " + node.lastName);
        System.out.println("Address: " + node.address + ", " + node.city + ", " 
        + node.state + " " + node.zip);
        System.out.println("Email: " + node.email);
        System.out.println("Phone: " + node.phone);
        System.out.println();
    }

    // Method to search for an entry in the dictionary by key
    Node searchByKey(Node root, String key) {
        if (root == null || root.key.equals(key))
            return root;

        if (root.key.compareTo(key) < 0)
            return searchByKey(root.right, key);

        return searchByKey(root.left, key);
    }

    // Method to delete an entry from the dictionary by key
    void deleteEntry(String key) {
        root = deleteRec(root, key);
    }

    // Recursive helper method to delete an entry from the dictionary by key
    private Node deleteRec(Node root, String key) {
        if (root == null)
            return root;

        if (key.compareTo(root.key) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // Method to find the minimum value in a subtree (helper for delete operation)
    private String minValue(Node root) {
        String minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Method to modify details of an existing entry in the dictionary by key
    void modifyEntry(String key) {
        Node node = searchByKey(root, key);
        if (node != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new details for the entry:");
            System.out.print("First Name: ");
            node.firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            node.lastName = scanner.nextLine();
            System.out.print("Address: ");
            node.address = scanner.nextLine();
            System.out.print("City: ");
            node.city = scanner.nextLine();
            System.out.print("State: ");
            node.state = scanner.nextLine();
            System.out.print("ZIP: ");
            node.zip = scanner.nextLine();
            System.out.print("Email: ");
            node.email = scanner.nextLine();
            System.out.print("Phone: ");
            node.phone = scanner.nextLine();
            System.out.println("Entry modified successfully.");
            scanner.close();
        } else {
            System.out.println("Entry with key " + key + " not found.");
        }
    }
    
    // Method to count the number of entries in the dictionary
    int countEntries(Node root) {
        if (root == null)
            return 0;

        return 1 + countEntries(root.left) + countEntries(root.right);
    }
}
