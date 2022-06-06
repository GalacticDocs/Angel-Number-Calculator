package angel.number.calculator.interfaces;

public interface IStringBuilder {
    /**
     * Appends the given string to the end of the string.
     * 
     * @param str The string to append.
     * @return The new string.
     */
    String append(String str);

    /**
     * @return The string that was built.
     */
    String toString();

    /**
     * Removes provided string from the current string.
     * 
     * @param val The string to remove.
     * @return The current string minus the string provided to remove.
     */
    String remove(String val);

    /**
     * Replaces provided old value with new value.
     * 
     * @param old    The old value to replace.
     * @param newVal The new value to replace with.
     * @return The new string.
     */
    String replace(String old, String newVal);
}
