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

    // returns the square of the number
    public static long square(long n) {
        return (long) Math.pow(n, 2);
    }

    // returns the square of the double
    public static double square(double n) {
        return (double) Math.pow(n, 2);
    }

    // returns the square of the float
    public static float square(float n) {
        return (float) Math.pow(n, 2);
    }

    // returns the cube of the number
    public static long cube(long n) {
        return (long) Math.pow(n, 3);
    }

    // returns the cube of the double
    public static double cube(double n) {
        return (double) Math.pow(n, 3);
    }

    // returns the cube of the float
    public static float cube(float n) {
        return (float) Math.pow(n, 3);
    }

}
