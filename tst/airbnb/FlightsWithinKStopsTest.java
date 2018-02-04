package airbnb;

import org.junit.Test;

import java.util.List;

import static airbnb.FlightsWithinKStops.Flight;
import static org.junit.Assert.assertEquals;

public class FlightsWithinKStopsTest {

    private FlightsWithinKStops flightsWithinKStops = new FlightsWithinKStops();

    @Test
    public void testHappyCase() {
        List<Flight> flights = List.of(
                new Flight("A", "B", 5),
                new Flight("B", "A", 1),
                new Flight("A", "C", 1),
                new Flight("C", "B", 1)
        );

        assertEquals(List.of("A", "C", "B"), flightsWithinKStops.minCost(flights, "A", "B", 1));
        assertEquals(List.of("A", "B"), flightsWithinKStops.minCost(flights, "A", "B", 0));
        assertEquals(List.of("A"), flightsWithinKStops.minCost(flights, "A", "A", 1));
    }
}
