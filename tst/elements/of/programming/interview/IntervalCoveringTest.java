package elements.of.programming.interview;

import static elements.of.programming.interview.IntervalCovering.Interval;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IntervalCoveringTest {

    private List<Interval> intervals = Arrays.asList(
            new Interval(1,2),
            new Interval(2,3),
            new Interval(3,4),
            new Interval(2,3),
            new Interval(3,4),
            new Interval(4,5)
    );

    @Test
    public void testFindMinVisitsBySmallestRight() {
        List<Integer> result = IntervalCovering.findMinVisits(intervals);
        System.out.println(result);
    }

    @Test
    public void testFindMinVisitsByGreatestLeft() {
        List<Integer> result = IntervalCovering.findMinVisitByGreatestLeft(intervals);
        System.out.println(result);
    }

    @Test
    public void testFindMinVisitsByGreatestLeftNaturalOrder() {
        List<Integer> result = IntervalCovering.findMinVisitByGreatestLeftNatrualOrder(intervals);
        System.out.println(result);
    }
}
