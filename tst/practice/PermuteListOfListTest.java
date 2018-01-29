package practice;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PermuteListOfListTest {

    PermuteListOfList solution = new PermuteListOfList();

    @Test
    public void test0() {
        List<List<Character>> input = List.of(List.of('A', 'B', 'C'), List.of('D','E'), List.of('F'));
        List<List<Character>> output = solution.permute(input);
        System.out.println(output);
        List<List<Character>> expected = List.of(List.of('A', 'D', 'F'),
                List.of('A', 'E', 'F'),
                List.of('B', 'D', 'F'),
                List.of('B', 'E', 'F'),
                List.of('C', 'D', 'F'),
                List.of('C', 'E', 'F'));
        assertEquals(expected, output);
    }
}
