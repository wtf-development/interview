package io.wdev.sort;

public class BubleSort {

    public static <T extends Comparable<T>> void  sort(T[] items) {

        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 1; i < items.length; i++) {
                if (items[i - 1].compareTo(items[i]) > 0) {
                    swap(items, i - 1, i);
                    swapped = true;

                }
            }
        } while (swapped);
    }

    private static <T extends Comparable<T>> void swap(T[] items, int from, int to) {
        if (from == to) {
            return;
        }

        T buf = items[from];
        items[from] = items[to];
        items[to] = buf;
    }
}
