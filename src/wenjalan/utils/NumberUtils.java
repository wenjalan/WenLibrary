package wenjalan.utils;

public class NumberUtils {

    // non instantiable
    private NumberUtils() {
        throw new AssertionError("class is non-instantiable");
    }

    // returns the digit at a given place of a long
    public static int getDigitAt(long num, int index) {
        int length = lengthOf(num);
        if (index < 0 || length < index) throw new IndexOutOfBoundsException("" + index);
        int place = lengthOf(num) - index;
        return (int) (num / ((int) Math.pow(10, place - 1)) % 10);
    }

    // returns the length of a long
    public static int lengthOf(long num) {
        return ("" + num).length();
    }

}
