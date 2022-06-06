package angel.number.calculator.builders;

import angel.number.calculator.interfaces.IStringBuilder;

public class StringBuilder implements IStringBuilder {
    private String string;

    /**
     * The main class for building strings.
     * 
     * @param str The original string to use.
     * @return The string builder.
     */
    public StringBuilder(String str) {
        this.string = str;
    }

    /**
     * Appends the given string to the end of the string.
     * 
     * @param str The string to append.
     * @return The new string.
     */
    @Override
    public String append(String appendable) {
        return this.string + appendable;
    }

    /**
     * @return The string that was built.
     */
    @Override
    public String toString() {
        return this.string;
    }

    /**
     * Removes provided string from the current string.
     * 
     * @param val The string to remove.
     * @return The current string minus the string provided to remove.
     */
    @Override
    public String remove(String val) {
        return this.string.replace(val, "");
    }

    /**
     * Replaces provided old value with new value.
     * 
     * @param old    The old value to replace.
     * @param newVal The new value to replace with.
     * @return The new string.
     */
    @Override
    public String replace(String old, String newVal) {
        return this.string.replace(old, newVal);
    }
}
