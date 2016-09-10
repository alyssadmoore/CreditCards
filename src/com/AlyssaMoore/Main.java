package com.AlyssaMoore;

import java.util.Scanner;

public class Main {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a Visa credit card number");
        String ccnum = stringScanner.nextLine();
        boolean valid = isVisaCreditCardNumberValid(ccnum);
        System.out.println("True or false, this is a valid number: " + valid);
    }
    public static boolean isVisaCreditCardNumberValid(String ccnum) {
        boolean valid = true;
        int total = 0;
        char[] chararray = ccnum.toCharArray();
        if (ccnum.length() != 16)
            valid = false;
        else if ((chararray[0] - '0') != 4)
            valid = false;
        for (int x = 0; x < 16;) {
            int valueodd = ((chararray[x] - '0') * 2);
            if (valueodd >= 10) {
                char[] valuearray = Integer.toString(valueodd).toCharArray();
                valueodd = (valuearray[0] - '0') + (valuearray[1] - '0');
            }
            total += valueodd;
            x += 1;
            int valueeven = (chararray[x] - '0');
            total += valueeven;
            x += 1;
        }
        if (total%10 != 0)
            valid = false;
        return valid;
    }
}