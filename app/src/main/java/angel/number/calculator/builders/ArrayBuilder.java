package angel.number.calculator.builders;

import angel.number.calculator.interfaces.IArrayBuilder;

public class ArrayBuilder<T> implements IArrayBuilder<T> {
    private T[] array;

    /**
     * The main class for building arrays.
     * 
     * @param arr The original array to use.
     * @return The array builder.
     */
    public ArrayBuilder(T[] arr) {
        this.array = arr;
    }

    /**
     * Joins the array into a string.
     * 
     * @param separator The separator to use.
     * @param start     The starting index.
     * @param end       The ending index.
     * @param reverse   Whether to reverse the array.
     * @return The string.
     */
    @Override
    public String join(String separator, int start, int end, boolean reverse) {
        StringBuilder sb = new StringBuilder("");

        if (reverse) {
            for (int i = end; i >= start; i--) {
                sb.append(this.array[i].toString());

                if (i != start) {
                    sb.append(separator);
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                sb.append(this.array[i].toString());

                if (i != end) {
                    sb.append(separator);
                }
            }
        }

        return sb.toString();
    }

    /**
     * Fetches the length of the array.
     * 
     * @return The length.
     */
    @Override
    public int length() {
        return this.array.length;
    }

    /**
     * Fetches the element at the given index.
     * 
     * @param index The index.
     * @return The element.
     */
    @Override
    public T get(int index) {
        return this.array[index];
    }

    /**
     * Sets the element at the given index.
     * 
     * @param index The index.
     * @param value The value.
     */
    @Override
    public void set(int index, T value) {
        this.array[index] = value;
    }

    /**
     * Adds the given element to the end of the array.
     * 
     * @param value The value.
     */
    @Override
    public void push(T value) {
        T[] newArray;

        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }

        
				if (value == String) {
					String val = "";

					if (value == "whitespace") {
						val = "\n";
					} else {
						val = value
					}

					newArray[newArray.length - 1] = val;
        	this.array = newArray;
					return;
				}
				
				newArray[newArray.length - 1] = value;
        this.array = newArray;
    }

    /**
     * Removes the element at the given index.
     * 
     * @param index The index.
     */
    @Override
    public void remove(int index) {
        T[] newArray = new T[this.array.length - 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = this.array[i];
        }

        for (int i = index + 1; i < this.array.length; i++) {
            newArray[i - 1] = this.array[i];
        }

        this.array = newArray;
    }

    /**
     * Removes the given element from the array.
     * 
     * @param value The value.
     */
    @Override
    public void remove(T value) {
        int index = -1;

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(value)) {
                index = i;

                break;
            }
        }

        if (index != -1) {
            this.remove(index);
        }
    }

    @Override
    public void reverse() {
        T[] newArray = new T[this.array.length];

        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[this.array.length - i - 1];
        }

        this.array = newArray;
    }

    @Override
    public void clear() {
        this.array = new T[0];
    }

    @Override
    public boolean includes(T value) {
        for (T s : this.array) {
            if (s.equals(value)) {
                return true;
            }
        }

        return false;
    }

	@Override
	public T[] build() {
		return this.array;
	} 
}
