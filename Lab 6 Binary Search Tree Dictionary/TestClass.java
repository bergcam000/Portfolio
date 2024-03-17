// Cameron Berg
// Class: CS&145
// Date 3/10/2024
// Lab 6 Binary Search Tree Dictionary
// Purpose: This program is designed to test the tree that I created in the Dictonary.java file

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();

        dictionary.addEntry("123", "John", "Doe", "123 Main St", "Anytown",
         "CA", "12345", "john@example.com", "123-456-7890");

        int choice;
        do {
            System.out.println("Dictionary Menu:");
            System.out.println("1. Add Entry");
            System.out.println("2. Delete Entry");
            System.out.println("3. Modify Entry");
            System.out.println("4. Lookup Entry");
            System.out.println("5. List Number of Entries");
            System.out.println("6. Pre-order Traversal");
            System.out.println("7. Post-order Traversal");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter details for the new entry:");
                    System.out.print("Key: ");
                    String key = scanner.nextLine();
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    System.out.print("ZIP: ");
                    String zip = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    dictionary.addEntry(key, firstName, lastName, address, city,
                     state, zip, email, phone);
                    System.out.println("Entry added successfully.");
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    String delKey = scanner.nextLine();
                    dictionary.deleteEntry(delKey);
                    System.out.println("Entry deleted successfully.");
                    break;
                case 3:
                    System.out.print("Enter key to modify: ");
                    String modKey = scanner.nextLine();
                    dictionary.modifyEntry(modKey);
                    break;
                case 4:
                    System.out.println("Choose the type of lookup:");
                    System.out.println("1. In-order Traversal");
                    System.out.println("2. Exit");
                    System.out.print("Enter your choice: ");
                    int lookupChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (lookupChoice) {
                        case 1:
                            System.out.println("In-order traversal:");
                            dictionary.inorderTraversal(dictionary.root);
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 5:
                    int numEntries = dictionary.countEntries(dictionary.root);
                    System.out.println("Number of entries in the dictionary: " + numEntries);
                    break;
                case 6:
                    System.out.println("Pre-order traversal:");
                    dictionary.preorderTraversal(dictionary.root);
                    break;
                case 7:
                    System.out.println("Post-order traversal:");
                    dictionary.postorderTraversal(dictionary.root);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);

        scanner.close();
    }
}
