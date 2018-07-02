package io.wdev.datastructures;

public class Queue<T> implements DataStruct {

    private Object[] data;
    private int capacity;
    private int count;
    private int head;
    private int tail;

    public Queue() {
        init(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        init(capacity);
    }

    private void init(int capacity) {
        this.data = new Object[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public <T> void push(T element) {
        tail = count % capacity;
        data[tail] = element;
        if (count != 0 && tail == head) {
            head = (head + 1) % capacity;
        }
        count++;
    }

    @Override
    public <T> T pop() {
        if (count == 0) {
            return null;
        }
        T result = (T) data[head];
        data[head] = null;
        count--;
        if (count != 0) {
            head = (head + 1) % capacity;
        } else {
            head = tail;
        }

        return result;
    }
}
