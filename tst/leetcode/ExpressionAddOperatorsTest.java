package leetcode;

import org.junit.Test;

import java.util.List;

public class ExpressionAddOperatorsTest {

    ExpressionAddOperators solution = new ExpressionAddOperators();

    @Test
    public void test() {
        System.out.println(solution.isTarget("1+2*3*4-5*6", -5));

        List<String> result = solution.addOperators("1000000009",9);
        System.out.println(result.size());
        System.out.println(result);

        List<String> result2 = solution.addOperators2("1000000009",9);
        System.out.println(result2.size());

        result2.removeAll(result);
        System.out.println(result2.size());
        System.out.println(result2);
    }


}
