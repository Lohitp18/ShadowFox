import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void display() {
        System.out.println("Name : " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}

public class ContactManager {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> updateContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("\nContact #" + (i + 1));
            contacts.get(i).display();
        }
    }

    static void updateContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); 

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new Name: ");
            String name = sc.nextLine();
            System.out.print("Enter new Phone: ");
            String phone = sc.nextLine();
            System.out.print("Enter new Email: ");
            String email = sc.nextLine();

            contacts.set(index, new Contact(name, phone, email));
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // consume newline

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }
}
