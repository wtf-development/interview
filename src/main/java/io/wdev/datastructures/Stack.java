package io.wdev.datastructures;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> implements DataStruct {

    private Object[] data;
    private int size;

    public Stack() {
        init(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        init(capacity);
    }

    private void init(int capacity) {
        data = new Object[capacity];
        size = 0;
    }


    public <T> void push(T element) {
        ensureCapacity();
        data[size++] = element;
    }

    public <T> T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T res = (T) data[--size];
        data[size] = null;
        return res;

    }

    private void ensureCapacity() {
        if (data.length == size)
            data = Arrays.copyOf(data, 2 * size + 1);
    }

}
