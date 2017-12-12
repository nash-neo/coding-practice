package elements.of.programming.interview;

import leetcode.RemoveInvalidParentheses;
import org.junit.Test;

import java.util.List;

public class RemoveInvalidParenthesesTest {

    private RemoveInvalidParentheses solution = new RemoveInvalidParentheses();

    @Test
    public void test() {
        String input = "())";
        List<String> result = solution.removeInvalidParentheses(input);
        System.out.println(result);
    }
}
