package io.wdev.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * The class provides methods to design a data structure that supports all following operations in average O(1) time.
 *
 * 1. insert(val): Inserts an item val to the set if not already present.
 * 2. remove(val): Removes an item val from the set if present.
 * 3. getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * @author WTF Development
 */
public class RandomizedList<T> {

    private Random rand;
    private HashMap<T, Integer> indexes;
    private List<T> items;

    public RandomizedList() {
        rand = new Random(System.currentTimeMillis());
        indexes = new HashMap<>();
        items = new ArrayList<>();
    }

    public RandomizedList(int capacity) {
        rand = new Random(System.currentTimeMillis());
        indexes = new HashMap<>(capacity);
        items = new ArrayList<>(capacity);
    }

    public boolean insert(T val) {
        if(indexes.containsKey(val)) {
            return false;
        }
        indexes.put(val, items.size());
        items.add(val);
        return true;
    }

    public boolean remove(T val) {
        if(!indexes.containsKey(val)) {
            return false;
        }
        int index = indexes.remove(val);
        T last = items.remove(items.size()-1);
        if(last != val) {
            items.set(index, last);
            indexes.put(last, index);
        }
        return true;
    }

    public T getRandom() {
        return items.get(rand.nextInt(items.size()));
    }
}
