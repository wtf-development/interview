package io.wdev.algorithms;

import java.util.Stack;

public class BalancedBrackets {

    private final static char[][] TOKENS = {{'{', '}'},{'(',')'},{'[',']'}};

    private static boolean isHead(char c) {
        for (char[] arr: TOKENS) {
            if (arr[0] == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasHead(char head, char c) {
        for (char[] arr: TOKENS) {
            if (arr[1] == c && arr[0] == head) {
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
                if (stack.isEmpty() || !hasHead(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return true;
    }
}
