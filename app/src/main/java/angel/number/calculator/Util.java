package angel.number.calculator;

import angel.number.calculator.builders.ArrayBuilder;
import angel.number.calculator.builders.StringBuilder;

public class Util {
    /**
     * Sends a message to the console.
     * 
     * @param message The message to send.
     * @return The message.
     */
    public void Print(String message) {
        System.out.println(message);
    }

    /**
     * Sends a message to the console.
     * 
     * (Accepts an array of strings to print out.)
     * @param message The message to print.
     * @return The message.
     */
    public void Print(String[] message) {
        StringBuilder value = new StringBuilder("");

        for (String s : message) {
            value.append(s);
            value.append("\n");
        }

        System.out.println(value.toString());
    }

    /**
     * Exits the program either successfully or failure.
     * @param state If said exit is "failure" or "success".
     * @return 
     */
    public void Exit(String state, String exception) {
        ArrayBuilder builder = new ArrayBuilder<String>(new String[]{});
        
        if (state.equals("success")) {
            Print("Program exitted with code 0 (success).");
            System.exit(0);
        } else if (state.equals("failure")) {
            builder.push("Program exitted with code 1 (failure).");
            if (!exception.equals("")) {
                builder.push("Exception: " + exception);
								builder.push("Please check the error log for more information.");
            		builder.push("whitespace");
            }

            Print(builder.build());
            System.exit(1);
        }
    }

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

        if (res != -1) {
            return res;
        } else {
            
        }
    }

    /**
     * Checks if said year is a leap year.
     * 
     * @param year Year to check.
     * @return Whether the year is a leap year.
     */
    public boolean IsLeapYear(int year) {
        String val = IntToString(year);

        if (val.length() != 4) {

        }
    }
}