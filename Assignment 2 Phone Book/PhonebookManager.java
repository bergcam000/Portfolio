// Cameron Berg
// Class: CS&145
// Date 2/6/24
// Assignment 2: Phone Book
// Purpose: Manages the operations for a phone book implemented as a single linked list.

public class PhonebookManager {
    private ListNode head;

    // Constructor initializes the phone book with an empty list
    public PhonebookManager() {
        this.head = null;
    }

    // Adds a new entry at the beginning of the phone book
    public void addEntryAtBeginning(String firstName, String lastName,
     String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(firstName, lastName, address, city, phoneNumber);
        newNode.next = head;
        head = newNode;
    }

    // Adds a new entry at the end of the phone book
    public void addEntryAtEnd(String firstName, String lastName,
     String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(firstName, lastName, address, city, phoneNumber);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Adds a new entry at a specific index in the phone book
    public void addEntryAtIndex(int index, String firstName, String lastName,
     String address, String city, String phoneNumber) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            addEntryAtBeginning(firstName, lastName, address, city, phoneNumber);
            return;
        }
        ListNode newNode = new ListNode(firstName, lastName, address, city, phoneNumber);
        ListNode current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid index");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Deletes an entry at a specific index from the phone book
    public void deleteEntryAtIndex(int index) {
        if (index < 0 || head == null) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Invalid index");
        } else {
            current.next = current.next.next;
        }
    }

    // Modifies the fields of an entry at a specific index in the phone book
    public void modifyEntryFields(int index, String newFirstName, String newLastName,
     String newAddress, String newCity, String newPhoneNumber) {
        ListNode current = getNodeAtIndex(index);
        if (current != null) {
            current.firstName = newFirstName;
            current.lastName = newLastName;
            current.address = newAddress;
            current.city = newCity;
            current.phoneNumber = newPhoneNumber;
        }
    }

    // Helper method to get the node at a specific index
    private ListNode getNodeAtIndex(int index) {
        if (index < 0 || head == null) {
            System.out.println("Invalid index");
            return null;
        }
        ListNode current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid index");
        }
        return current;
    }

    // Prints the entries in the phone book
    public void printPhonebook() {
        ListNode current = head;
        while (current != null) {
            System.out.println("Name: " + current.firstName + " " + current.lastName);
            System.out.println("Address: " + current.address);
            System.out.println("City: " + current.city);
            System.out.println("Phone Number: " + current.phoneNumber);
            System.out.println("------------------------");
            current = current.next;
        }
    }
}
