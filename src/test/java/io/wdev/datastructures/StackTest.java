package io.wdev.datastructures;

import org.junit.Test;

public class StackTest {

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println((Integer) stack.pop());
        System.out.println((Integer) stack.pop());
    }
}
