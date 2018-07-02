package io.wdev.datastructures;

public interface DataStruct {

    int DEFAULT_CAPACITY = 8;

    <T> void push(T element);
    <T> T pop();
}
