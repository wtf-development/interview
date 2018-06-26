package io.wdev.algorithms.graphtheory;

import org.junit.Test;

public class ValueOfFriendshipTest {

    @Test
    public void test() {
        int[][] arr = new int[4][];
        arr[0] = new int[]{1,2};
        arr[1] = new int[]{3,2};
        arr[2] = new int[]{4,2};
        arr[3] = new int[]{4,3};
        System.out.println(ValueOfFriendship.valueOfFriendsship(5, arr));
    }

    @Test
    public void test1() {
        int[][] arr = new int[4][];
        arr[0] = new int[]{1,2};
        arr[1] = new int[]{2,3};
        arr[2] = new int[]{1,3};
        arr[3] = new int[]{4,5};
        System.out.println(ValueOfFriendship.valueOfFriendsship(5, arr));
    }
}
