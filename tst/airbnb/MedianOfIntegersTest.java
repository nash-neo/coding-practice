package airbnb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianOfIntegersTest {

    @Test
    public void test() {
        assertEquals(2, MedianOfIntegers.findMedian(new int[]{1,1,2,2,3}));
        assertEquals(2, MedianOfIntegers.findMedian(new int[]{1,1,2,3}));
        assertEquals(2, MedianOfIntegers.findMedian(new int[]{0,1,1,1,2,2,3,4}));
        assertEquals(1, MedianOfIntegers.findMedian(new int[]{0,1,1,1,2,3,4}));
    }
}
