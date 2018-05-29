package io.wdev.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The class provides tests for StringReverse
 *
 * @author WTF Development
 */
public class StringReverseTest {

    @Test
    public void testReverse() {
        // given
        String source = "1234567890";
        //when
        String target = StringReverse.reverse(source);
        //then
        String reversed = new StringBuffer(source).reverse().toString();
        assertEquals("StringReverse.reverse(String) should return " + reversed, target, reversed);
    }

    @Test
    public void testReverseUTF8() {
        // given
        String source = "👶👧👩👵💀🤖";
        //when
        String target = StringReverse.reverse(source);
        //then
        String reversed = new StringBuffer(source).reverse().toString();
        assertEquals("StringReverse.reverse(String) should return " + reversed, target, reversed);
    }
}
