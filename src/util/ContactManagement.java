package util;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ContactManagement {

    public static Input ask = new Input();
    public static Path path = Paths.get("contacts.txt");

    public static void mainMenu() {
//        do {
        System.out.println("1. View Contacts");
        System.out.println("2. Add a new Contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1,2,3,4 or 5)");
//        }
    }



    public static List<String> slurp(){
        try {

            System.out.println("slurp good to go");
            return Files.readAllLines(Paths.get(String.valueOf(path)));

        }catch (IOException e){
            System.out.println(e);
            System.exit(1);
            return null;
        }
    }
    public static List<String> contacts;
    public static List<String> viewContacts(){
        contacts = slurp();
//        System.out.println(contacts);
        return contacts;
    }

    public static void printContacts(List<String> contacts){
//        viewContacts();
        System.out.printf("%-15s | %s\n", "First Last", "PhoneNum");
        System.out.println("-----------------------------");
        for(String contact: contacts){
            String name = contact.substring(0, contact.indexOf("#"));
            String number = contact.substring(contact.indexOf("#")+1);
            System.out.printf("%-15s | %s\n", name, number);
            System.out.println("-----------------------------");
        }
    }

    public static void addContact(){
        List<String> newEntry = new ArrayList<>();
        String entry = ask.getString("Enter your name: (First Last)") +" #"+ ask.getInt("Enter your phone number: ");
        newEntry.add(entry);

        try {
            //            modified from path variable
            Files.write(Paths.get(String.valueOf(path)), newEntry, StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println("Who Care!");
        }
    }

    public static void searchContacts(){
        String name = ask.getString("What name do you want to find?: ");
        List<String> results = new ArrayList<>();
        for(String contact: slurp()){
            if (contact.contains(name)){
                results.add(contact);
            }
        }
//        printContacts(results);
    }

    public static void main(String[] args) {
        slurp();
        viewContacts();
        printContacts(contacts);
        addContact();
        System.out.println("--reprint of contacts--------");
        printContacts(contacts);
    }

}
