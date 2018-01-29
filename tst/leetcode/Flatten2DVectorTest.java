package leetcode;

import airbnb.Flatten2DVector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flatten2DVectorTest {

    private Flatten2DVector flatten2DVector;

    @Test
    public void test() {
        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(new ArrayList<>(Arrays.asList(1,2,3)));
        vec2d.add(new ArrayList<>(Arrays.asList()));
        vec2d.add(new ArrayList<>(Arrays.asList(4)));
        vec2d.add(new ArrayList<>(Arrays.asList(5,6)));
        flatten2DVector = new Flatten2DVector(vec2d);

        flatten2DVector.next();
        flatten2DVector.next();
        flatten2DVector.next();
        flatten2DVector.next();
        flatten2DVector.next();
        flatten2DVector.next();
        flatten2DVector.remove();

        flatten2DVector = new Flatten2DVector(vec2d);
        while(flatten2DVector.hasNext()) {
            System.out.println(flatten2DVector.next());
        }
    }
}
