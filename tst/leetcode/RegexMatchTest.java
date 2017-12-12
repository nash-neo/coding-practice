package leetcode;

import org.junit.Test;

public class RegexMatchTest {
    private RegexMatch regexMatch = new RegexMatch();

    @Test
    public void test() {
        System.out.println(regexMatch.isMatch("aa", ".*c"));
    }
}
