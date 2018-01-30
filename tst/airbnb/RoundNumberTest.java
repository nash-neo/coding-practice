package airbnb;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RoundNumberTest {

    private RoundNumber roundNumber = new RoundNumber();

    @Test
    public void test0() {
        List<Double> X = List.of(2.3, 3.4, 1.5);
        List<Long> Y = roundNumber.round(X);
        System.out.println(Y);
        assertEquals(List.of(2L, 3L, 2L), Y);
    }
}
