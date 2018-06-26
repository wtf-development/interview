package io.wdev.algorithms;

import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

public class BalancedBracketsTest {

    @Test
    public void test() {

        Collection<String> source = givenStrings();

        source.stream().forEach(e -> {
            if (BalancedBrackets.isBalanced(e)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        });

    }

    private Collection<String> givenStrings() {
        Collection<String> strings = new LinkedList<>();
        strings.add("{[()]}");
        strings.add("{[(])}");
        strings.add("{{[[(())]]}}");
        strings.add("{{[[(())]]}()}");
        strings.add("{{[[(())]]}() }");

        return strings;
    }
}
