package wenjalan;

public class NumberUtils {

    // non instantiable
    private NumberUtils() {
        throw new AssertionError("class is non-instantiable");
    }

    // returns the digit at a given position of a number
    public static byte getDigitAt(long num, int position) {
        String numString = "" + num;
        char digit = numString.charAt(position);
        return Byte.parseByte("" + digit);
    }

}
