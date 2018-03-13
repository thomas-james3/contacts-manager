package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class ContactManagement {
    /**
     * The application should be able to:
     * Show all your contacts
     * Add a new contact
     * Search a contact by her name
     * Delete an existing contact
     * The application should keep its data in a file named contacts.txt so that the information persists between runs of the application.
     */

//    Show all contacts
    public static List<String> showContacts(String filepath, String... more) {
        List<String> data = new ArrayList<>();
        try {
            Path path = Paths.get(filepath, more);
            System.out.println(path);
            System.out.println(Files.exists(path));
            data = Files.readAllLines(Paths.get(filepath, more));
            for (int i = 0; i < data.size(); ++i) {
                String line = data.get(i);
                System.out.printf("%s: %s\n", i + 1, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return data;
    }

//    Add a contact
    public static void addContact(String filename, List<String> contents) {
        try{
            Files.write(Paths.get(filename), contents, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("WTF");
            System.exit(1);
        }

    }

    public void searchContacts() {
        try {
            Path path = Paths.get("contacts.txt");
            System.out.println(path);
            System.out.println(Files.exists(path));
            List<String> data = Files.readAllLines(Paths.get("contacts.txt"));
            for (int i = 0; i < data.size(); ++i) {
                String line = data.get(i);
                System.out.printf("%s: %s\n", i + 1, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static void deleteContact() {

    }

    public static void main(String[] args) {
        System.out.println("---------show contacts");
        showContacts("contacts.txt");

        List<String> newStuff = new ArrayList<>();
        newStuff.add("test");
        newStuff.add("test test test");

        addContact("contacts.txt",newStuff);

        System.out.println("---------show contacts");
        showContacts("contacts.txt");
    }
}





