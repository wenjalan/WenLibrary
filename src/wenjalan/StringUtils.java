package wenjalan;

public class StringUtils {

    // non instantiable
    private StringUtils() {}

    // returns the string appended to itself multiplier times
    // ex: appendMult("hello", 3) returns hellohellohello
    public static String appendMult(CharSequence s, int multipler) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < multipler; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

}
