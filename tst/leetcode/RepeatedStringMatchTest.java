package leetcode;

import org.junit.Test;

public class RepeatedStringMatchTest {

    private RepeatedStringMatch solution = new RepeatedStringMatch();

    @Test
    public void test() {
        String A = "baaabbbaba";

        String B = "baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba";

        solution.repeatedStringMatch(A,B);

    }
}
