package leetcode;

import org.junit.Test;

public class ReconstructItineraryTest {

    ReconstructItinerary reconstructItinerary = new ReconstructItinerary();

    @Test
    public void test() {
        String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        System.out.println(reconstructItinerary.findItinerary(tickets));
    }
}
