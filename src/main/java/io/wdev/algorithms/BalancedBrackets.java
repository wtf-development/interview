package io.wdev.algorithms;

import java.util.Stack;

public class BalancedBrackets {

    // dictionary[n][0] is head
    // dictionary[n][1] is tail
    private final static char[][] dictionary = {{'{', '}'},{'(',')'},{'[',']'}};

    private static boolean isHead(char c) {
        for (char[] dict: dictionary) {
            if (dict[0] == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTail(char c) {
        for (char[] dict: dictionary) {
            if (dict[1] == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMyHead(char head, char tail) {
        for (char[] dict: dictionary) {
            if (dict[1] == tail && dict[0] == head) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBalanced(String source) {
        char[] symbols = source.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c: symbols) {
            if (isHead(c)) {
                stack.push(c);
            } else {
                if (isTail(c) && (stack.isEmpty() || !isMyHead(stack.pop(), c))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
