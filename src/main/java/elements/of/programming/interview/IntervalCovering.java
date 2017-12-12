package elements.of.programming.interview;

import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class IntervalCovering {
    //[1,2],[2,3],[3,4],[2,3],[3,4],[4,5]

    @Value
    public static class Interval {
        private int left;
        private int right;
    }

    public static List<Integer> findMinVisits(@NonNull  List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.getRight() - o2.getRight();
            }
        });
        List<Integer> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            return result;
        }
        int currRight = intervals.get(0).getRight();
        result.add(currRight);
        for (Interval interval : intervals) {
            //find the next uncovered interval
            if (interval.getLeft() > currRight) {
                currRight = interval.getRight();
                result.add(currRight);
            }
        }
        return result;
    }

    public static List<Integer> findMinVisitByGreatestLeft(@NonNull  List<Interval> intervals) {
        //intervals.sort((o1, o2) -> o1.getRight() - o2.getRight());
        intervals.sort(comparing(Interval::getRight).reversed());
        List<Integer> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            return result;
        }
        int currLeft = intervals.get(0).getLeft();
        result.add(currLeft);
        for (Interval interval : intervals) {
            //find the next uncovered interval
            if (interval.getRight() < currLeft) {
                currLeft = interval.getLeft();
                result.add(currLeft);
            }
        }
        return result;
    }

    public static List<Integer> findMinVisitByGreatestLeftNatrualOrder(@NonNull  List<Interval> intervals) {
        //intervals.sort((o1, o2) -> o1.getRight() - o2.getRight());
        intervals.sort(comparing(Interval::getRight));
        List<Integer> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            return result;
        }
        int currLeft = intervals.get(intervals.size()-1).getLeft();
        result.add(currLeft);
        for (int i = intervals.size()-2; i >=0; --i) {
            //find the next uncovered interval
            if (intervals.get(i).getRight() < currLeft) {
                currLeft = intervals.get(i).getLeft();
                result.add(currLeft);
            }
        }
        return result;
    }
}
