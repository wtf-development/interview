package io.wdev.sort;

import org.junit.Test;

import java.util.Random;

public class BubleSortTest {

    @Test
    public void testSort() {

        BubleSort.sort(generateRndArr(10, 9));
    }

    private Integer[] generateRndArr(int size, int bound) {
        Integer[] list = new Integer[size];
        Random r = new Random();
        for (int i=0; i<size; i++){
            list[i] = r.nextInt(bound)+1;
        }
        return list;
    }
}
