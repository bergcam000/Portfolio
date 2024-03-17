// Cameron Berg
// Class: CS&145
// Date 2/6/24
// Assignment 2: Phone Book
// Purpose: Represents a node in the phone book.

public class ListNode {
    String firstName;
    String lastName;
    String address;
    String city;
    String phoneNumber;
    ListNode next;

    public ListNode(String firstName, String lastName, String address, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }
}
