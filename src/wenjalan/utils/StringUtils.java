package wenjalan.utils;

public class StringUtils {

    // non instantiable
    private StringUtils() {
        throw new AssertionError("class is non-instantiable");
    }

    // returns the string appended to itself multiplier times
    // ex: appendMult("hello", 3) returns hellohellohello
    public static String appendMult(CharSequence s, int multipler) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < multipler; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    // truncates a String at the given char
    public static String truncateAt(String str, char c) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return str.substring(0, i);
            }
        }
        return str;
    }

//    // truncates a String at the given regex
//    public static String truncateAt(String str, String regex) {
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = 0; str.charAt(i) == regex.charAt(j); j++) {
//
//            }
//        }
//    }

}
