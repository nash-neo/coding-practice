package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SentenceScreenFittingTest {
    SentenceScreenFitting solution = new SentenceScreenFitting();

    @Test
    public void test0() {
        assertEquals(2, solution.wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));
    }

    @Test
    public void test1() {
        assertEquals(4, solution.wordsTyping(new String[]{"h"}, 2, 3));
    }

    @Test
    public void test2() {
        assertEquals(1, solution.wordsTyping(new String[]{"ab", "cde", "f"}, 3, 5));
    }
}
