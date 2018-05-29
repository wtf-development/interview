package io.wdev.strings;

/**
 * The class provides methods to reverse a utf-8 string
 *
 * @author WTF Development
 */
public class StringReverse {

    public static String reverse(String input) {
        StringBuilder buf = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (i > 0 && Character.isSurrogate(c)) {
                char c2 = input.charAt(i - 1);
                if (Character.isSurrogate(c2)) {
                    buf.append(c2);
                    i--;
                }
            }
            buf.append(c);
        }
        return buf.toString();
    }

}
