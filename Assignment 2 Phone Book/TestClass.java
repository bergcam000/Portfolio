// Cameron Berg
// Class: CS&145
// Date 2/6/24
// Assignment 2: Phone Book
// Purpose: Test class to demonstrate the functionality of the PhonebookManager.

public class TestClass {
    public static void main(String[] args) {
        // Create an instance of PhonebookManager
        PhonebookManager phonebookManager = new PhonebookManager();

        // Add entries to the phone book
        phonebookManager.addEntryAtBeginning("John", "Doe", "123 Main St", 
        "Cityville", "123-456-7890");
        phonebookManager.addEntryAtEnd("Jane", "Smith", "456 Oak St", 
        "Townsville", "987-654-3210");
        phonebookManager.addEntryAtIndex(1, "Alice", "Johnson", "789 Pine St", 
        "Villagetown", "555-123-4567");

        // Print the phone book entries
        System.out.println("Phonebook Entries:");
        phonebookManager.printPhonebook();

        // Modify an entry in the phone book
        phonebookManager.modifyEntryFields(1, "Bob", "Anderson", "888 Maple St", 
        "Suburbville", "999-888-7777");

        // Print the phone book entries after modification
        System.out.println("\nPhonebook Entries after modification:");
        phonebookManager.printPhonebook();

        // Delete an entry from the phone book
        phonebookManager.deleteEntryAtIndex(1);

        // Print the phone book entries after deletion
        System.out.println("\nPhonebook Entries after deletion:");
        phonebookManager.printPhonebook();
    }
}
