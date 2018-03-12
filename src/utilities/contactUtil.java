package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class contactUtil {
    /**
     * The application should be able to:
     * Show all your contacts
     * Add a new contact
     * Search a contact by her name
     * Delete an existing contact
     * The application should keep its data in a file named contacts.txt so that the information persists between runs of the application.
     */

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

    public static void addContact(String filename, List<String> contents) {
        try{
            Files.write(Paths.get(filename), contents, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("WTF");
            System.exit(1);
        }

    }

    public static void searchContats() {

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



//maybe use
//public static List<String> slurp(String filepath, String... more) {
//    List<String> data = new ArrayList<>();
//    try {
//        Path path = Paths.get(filepath, more);
//        System.out.println(path);
//        System.out.println(Files.exists(path));
//        data = Files.readAllLines(Paths.get(filepath, more));
//        for (int i = 0; i < data.size(); ++i) {
//            String line = data.get(i);
//            System.out.printf("%s: %s\n", i + 1, line);
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//        System.exit(1);
//    }
//    return data;
//}




//public static void spit(String filename, List<String> contents) {
//    spit(filename, contents, false);
//}
//    public static void spit(String filename, List<String> contents, Boolean... append) {
//        if (!Files.exists(Paths.get(filename))) {
//            try {
//                Files.createFile(Paths.get(filename));
//                System.out.println("created: " + filename);
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.exit(1);
//            }
//        }
//        if (append[0]) {
//            System.out.println("append true");
//            try {
//                Files.write(Paths.get(filename), contents, StandardOpenOption.APPEND);
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("WTF Happened?");
//                System.exit(1);
//            }
//        } else
//            try {
//                Files.write(Paths.get(filename), contents);
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.exit(1);
//            }
//
//
//    }