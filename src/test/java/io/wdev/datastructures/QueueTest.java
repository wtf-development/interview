package io.wdev.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new Queue<>(3);
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(queue.pop(), new Integer(1));
        assertEquals(queue.pop(), new Integer(2));
        assertEquals(queue.pop(), new Integer(3));
        assertNull(queue.pop());

        queue.push(0);
        queue.push(1);
        queue.push(2);

        assertEquals(queue.pop(), new Integer(0));
        assertEquals(queue.pop(), new Integer(1));
        assertEquals(queue.pop(), new Integer(2));
        assertNull(queue.pop());

        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(queue.pop(), new Integer(1));
        assertEquals(queue.pop(), new Integer(2));
        assertEquals(queue.pop(), new Integer(3));
        assertNull(queue.pop());
    }
}
