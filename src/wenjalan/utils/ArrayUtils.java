package wenjalan.utils;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

// A series of helper methods for dealing with arrays
public class ArrayUtils {

    // non instantiable
    private ArrayUtils() {
        throw new AssertionError("class is non-instantiable");
    }

    /*
     * primitive-to-boxed utils
     */
    public static Integer[] toBoxedArray(int[] a) {
        return (Integer[]) IntStream.of(a).boxed().toArray();
    }

    public static Double[] toBoxedArray(double[] a) {
        return (Double[]) DoubleStream.of(a).boxed().toArray();
    }

    public static Long[] toBoxedArray(long[] a) {
        return (Long[]) LongStream.of(a).boxed().toArray();
    }

    public static Character[] toBoxedArray(char[] a) {
        Character[] ret = new Character[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static Byte[] toBoxedArray(byte[] a) {
        Byte[] ret = new Byte[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static Short[] toBoxedArray(short[] a) {
        Short[] ret = new Short[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static Float[] toBoxedArray(float[] a) {
        Float[] ret = new Float[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static Boolean[] toBoxedArray(boolean[] a) {
        Boolean[] ret = new Boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    /*
     * boxed-to-primitive utils
     */
    public static int[] toPrimitiveArray(Integer[] a) {
        return Arrays.stream(a).mapToInt(n -> n).toArray();
    }

    public static double[] toPrimitiveArray(Double[] a) {
        return Arrays.stream(a).mapToDouble(n -> n).toArray();
    }

    public static long[] toPrimitiveArray(Long[] a) {
        return Arrays.stream(a).mapToLong(n -> n).toArray();
    }

    public static char[] toPrimitiveArray(Character[] a) {
        char[] ret = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static byte[] toPrimitiveArray(Byte[] a) {
        byte[] ret = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static short[] toPrimitiveArray(Short[] a) {
        short[] ret = new short[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static float[] toPrimitiveArray(Float[] a) {
        float[] ret = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static boolean[] toPrimitiveArray(Boolean[] a) {
        boolean[] ret = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

}
