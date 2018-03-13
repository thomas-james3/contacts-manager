package util;

import java.util.Scanner;
///redo with method overload ////
public class Input {

    private Scanner input;

    public Input() {
        input = new Scanner(System.in);
    }
    ////////////////////////////
//    GET STRING
    public String getString() {
        return this.input.nextLine();
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return this.input.next();
//        return getString();
    }
    ////////////////////////////////////
//    YES OR NO
    public boolean yesNo(String prompt) {
        System.out.println(prompt + " Yes/No");
        String yes = this.input.next().toLowerCase();
        return "y".equals( yes ) || yes.contains("yes");
    }
    /////////////////////////////////
//    GET INT
    public int getInt() {
//        System.out.println("Enter an integer");
        try {
            return Integer.parseInt(this.input.next());
        } catch(NumberFormatException e) {
            System.out.println("Invalid Input, Try Again: ");
            return getInt();
        }
    }

    public int getInt(String prompt) {
        System.out.println(prompt);
        return getInt();
    }

    public int getInt(int min, int max) {
        System.out.printf("Enter an Integer between %d and %d: ", min, max);
        int x = getInt();
        if (x >= min && x <= max) {
            return x;
        } else {
            return getInt(min, max);
        }
    }

    public int getInt(int min, int max, String prompt) {
        System.out.println(prompt);
        return getInt(min, max);
    }



    ////////////////////////////////////////
//    GET DOUBLE
    public double getDouble() {
        System.out.println("Enter a double");
        try {
            return Double.parseDouble(this.input.next());
        } catch(NumberFormatException e) {
            System.out.println("Invalid Input, Try Again: ");
            return getDouble();
        }
    }


    public double getDouble(String prompt) {
        System.out.println(prompt);
        return getDouble();
    }

    public double getDouble(double min, double max) {
        System.out.printf("Enter a Double between %.2f and %.2f: ", min, max);
        double y =  getDouble();
        if (y >= min && y <= max) {
            return y;
        }else {
            return getDouble(min, max);
        }
    }

    public double getDouble(double min, double max, String prompt) {
        System.out.println(prompt);
        return getDouble();
    }

    ////////////////////////////////////
//    GET BINARY
    public int getBinary() {
        try {
            System.out.println("Enter A Binary Number: ");
            return Integer.valueOf(this.input.next(), 2);
        } catch (NumberFormatException e) {
            System.out.print("Invalid Binary, try again: ");
            return getBinary();
        }
    }
    /////////////////////////////////////
//    GET HEXADECIMAL
    public int getHex() {
        try {
            System.out.println("Enter A Hexadecimal Number: ");
            return Integer.valueOf(this.input.next(), 16);
        } catch (NumberFormatException e) {
            System.out.print("Invalid Hexadecimal, try again: ");
            return getHex();
        }
    }







}
