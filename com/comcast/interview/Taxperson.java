package com.comcast.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Taxperson {
    private static final String TYPE_NECESSARY = "necessary";
    private static final String TYPE_LUXURY = "luxury";
    
    /** Valid input types. */
    private static final Set<String> TYPES = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(TYPE_NECESSARY, TYPE_LUXURY)));
    
    public static void main(String[] argvs) {
        // Check argument length, valid types, and valid whole number pennies.
        if (argvs.length != 2 || !TYPES.contains(argvs[0]) || !Taxperson.isValidPennies(argvs[1])) {
            Taxperson.printUsage();
            return;
        }
        
        System.out.println("Total price: " + Taxperson.total(argvs[0], argvs[1]) + "¢");
    }

    public static long total(String type, String pennies) {
        if (!Taxperson.isValidPennies(pennies)) {
            throw new IllegalArgumentException("Could not parse pennies: " + pennies);
        }
        return total(type, Long.parseLong(pennies));
    }

    private static long total(String type, long pennies) {
        double total = Math.floor(pennies + pennies * Taxperson.taxRate(type));
        // Fractions of pennies usually round down.
        return (long) total;
    }

    private static double taxRate(String type) {
        if (type.equals(TYPE_NECESSARY)) {
            return 0.01;
        } else if (type.equals(TYPE_LUXURY)) {
            return 0.09;         
        }
        throw new IllegalArgumentException("Unexpected type: " + type);
    }
    
    private static boolean isValidPennies(String value) {
        try {
            long number = Long.parseLong(value);
            if (number < 0) {
                return false;
            } else if (number != Math.ceil(number)) { // Whole number
                return false;
            }
            
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static void printUsage() {
        System.out.println("java -jar /path/to/Taxperson (necessary|luxury) amount_in_pennies");
    } 
}

