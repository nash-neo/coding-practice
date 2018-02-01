package airbnb;

import org.junit.Test;

import java.util.List;

public class WizardsTest {

    private Wizards solution = new Wizards();

    @Test
    public void test0() {
        List<List<Integer>> wizards = List.of(
                List.of(1,4,5), //0
                List.of(), //1
                List.of(), //2
                List.of(4), //3
                List.of(9,3), //4
                List.of(), //5
                List.of(), //6
                List.of(), //7
                List.of(), //8
                List.of() //9
                );
        System.out.println(solution.calculateDistance(wizards, 0, 9)); // normal
        System.out.println(solution.calculateDistance(wizards, 0, 8)); // unreachable
        System.out.println(solution.calculateDistance(wizards, 0, 3)); // have cycle
        System.out.println(solution.calculateDistance(wizards, 0, 0)); // to itself
    }
}
