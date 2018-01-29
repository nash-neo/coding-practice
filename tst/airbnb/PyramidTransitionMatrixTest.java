package airbnb;

import org.junit.Test;

import java.util.List;

public class PyramidTransitionMatrixTest {

    PyramidTransitionMatrix solution = new PyramidTransitionMatrix();

    @Test
    public void test0() {
        String bottom = "XYZ";
        List<String> allowed = List.of("XYD", "YZE", "DEA", "FFF");
        System.out.println(solution.pyramidTransition(bottom, allowed));
    }

    @Test
    public void test1() {
        String bottom = "XXYX";
        List<String> allowed = List.of("XXX", "XXY", "XYX", "XYY", "YXZ");
        System.out.println(solution.pyramidTransition(bottom, allowed));
    }
}
