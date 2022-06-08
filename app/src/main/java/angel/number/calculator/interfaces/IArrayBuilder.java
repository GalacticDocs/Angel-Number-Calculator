package angel.number.calculator.interfaces;

public interface IArrayBuilder<T> {
    /**
     * Joins the array into a string.
     * 
     * @param separator The separator to use.
     * @param start     The starting index.
     * @param end       The ending index.
     * @param reverse   Whether to reverse the array.
     * @return The string.
     */
    String join(String separator, int start, int end, boolean reverse);

    /**
     * Fetches the length of the array.
     * 
     * @return The length.
     */
    int length();

    /**
     * Fetches the element at the given index.
     * 
     * @param index The index.
     * @return The element.
     */
    T get(int index);

    /**
     * Sets the element at the given index.
     * 
     * @param index The index.
     * @param value The value.
     */
    void set(int index, T value);

    /**
     * Adds the given element to the end of the array.
     * 
     * @param value The value.
     */
    void push(T value);

    /**
     * Removes the element at the given index.
     * 
     * @param index The index.
     */
    void remove(int index);

    /**
     * Removes the given element from the array.
     * 
     * @param value The value.
     */
    void remove(T value);

    /**
     * Reverses the array.
     */
    void reverse();

    /**
     * Clears the array.
     */
    void clear();

    /**
     * Checks if a certain item exists in the array.
     */
    boolean includes(T value);

    /**
     * Builds and returns the array.
     */
    T[] build();
}