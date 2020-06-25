package cell_phone;

import java.util.ArrayList;
import java.util.Scanner;

class CellPhone {
    private String myNumber;
    private ArrayList<cell_phone.Contact> myContacts;
    private static Scanner scanner = new Scanner(System.in);
    private static CellPhone cellPhone = new CellPhone("123 456 7890");

    public CellPhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<cell_phone.Contact>();
    }

    public boolean addContact(cell_phone.Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public void quit() {
        System.out.println("\nShutting down...");
    }

    public boolean updateContact(cell_phone.Contact oldContact, cell_phone.Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(cell_phone.Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    private int findContact(cell_phone.Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            cell_phone.Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String searchContact(cell_phone.Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public cell_phone.Contact searchContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void showContacts() {
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + "." + this.myContacts.get(i).getName() + " ->" + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    cellPhone.quit();
                    quit = true;
                    break;
                case 1:
                    cellPhone.showContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number: ");
        String phone = scanner.nextLine();
        cell_phone.Contact newContact = cell_phone.Contact.saveContact(name, phone);
        if (cellPhone.addContact(newContact)) {
            System.out.println("New contact added: " + name + " -> " + phone);
        } else {
            System.out.println("Cannot add, " + name + " is already on file.");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        cell_phone.Contact existingContactRecord = cellPhone.searchContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: (leave blank if you do not wish to change the number");
        String newNum = scanner.nextLine();
        //users can change only the name by leaving the phone number blank
        cell_phone.Contact newContact;
        if (newNum.equals("")) {
            newContact = cell_phone.Contact.saveContact(newName, existingContactRecord.getPhoneNumber());
        } else {
            newContact = cell_phone.Contact.saveContact(newName, newNum);
        }
        if (cellPhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated contact.");
        } else {
            System.out.println("Error updating contact");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        cell_phone.Contact existingContactRecord = cellPhone.searchContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if (cellPhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted contact.");
        } else {
            System.out.println("Error deleting contact.");
        }
    }

    private static void searchContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        cell_phone.Contact existingContactRecord = cellPhone.searchContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + "\nPhone number: " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shut down\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - to search for existing contact\n" +
                "6 - to print a list of available actions\n");
        System.out.println("Choose your action: ");
    }
}


/*
**Cell Phone with Java Classes**
    - **CellPhone Class:**
        - Contact List
        - quit()
        - showContacts()
        - addContact()
        - updateContat()
        - removeContact()
        - searchContact()
      * **When adding or updating be sure to check if the contact already exists**
      * **Be sure not to expose the inner workings of the Arraylist to MobilePhone (use concepts of encapsulation to meet this requirement)**
*/
