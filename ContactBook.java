import java.util.LinkedList;
import java.util.Scanner;

public class ContactBook {
    private LinkedList<Contact> contacts;

    public ContactBook() {
        contacts = new LinkedList<>();
    }

    public void addContact(String name, String phoneNumber, String email) {
        contacts.add(new Contact(name, phoneNumber, email));
    }

    public void deleteContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void searchByEmail(String email) {
        for (Contact contact : contacts) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Contact found:");
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void printList() {
        System.out.println("Contact List:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void searchByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found:");
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();

        while (true) {
            System.out.println("*************************************************************************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("*************************************************************************************");
            System.out.print("Please Enter a command: ");
            String command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "A":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactBook.addContact(name, phoneNumber, email);
                    System.out.println("Contact added successfully.");
                    break;
                case "D":
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    contactBook.deleteContact(deleteName);
                    break;
                case "E":
                    System.out.print("Enter email to search: ");
                    String searchEmail = scanner.nextLine();
                    contactBook.searchByEmail(searchEmail);
                    break;
                case "P":
                    contactBook.printList();
                    break;
                case "S":
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    contactBook.searchByName(searchName);
                    break;
                case "Q":
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}
