package angel.number.calculator;

import angel.number.calculator.builders.StringBuilder;

public class Util {
    /**
     * Converts said integer value to a string.
     * 
     * @param value Integer to convert.
     * @return The string representation of the integer.
     */
    public String IntToString(int value) {
        return Integer.toString(value);
    }

    /**
     * Converts said string value to a integer.
     * 
     * @param value String to convert.
     * @return The integer value of the string.
     */
    public int StringToInt(String value) {
        int res = -1;

        try {
            int number = Integer.parseInt(value);
            res = number;
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        if res != -1 {
            return res;
        } else {

        }
    }

    /**
     * Sends a message to the console.
     */
    public void Print(String message) {
        System.out.println(message);
    }

    /**
     * Sends a message to the console.
     * 
     * (Accepts an array of strings to print out.)
     */
    public void Print(String[] message) {
        StringBuilder value = new StringBuilder("");

        for (String s : message) {
            value.append(s);
        }
    }

    /**
     * Checks if said year is a leap year.
     * 
     * @param year Year to check.
     */
    public boolean IsLeapYear(int year) {
        String val = IntToString(year);

        if (val.length() != 4) {

        }
    }
}