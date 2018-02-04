package airbnb;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

public class VertexCoverTest {

    private VertexCover vertexCover = new VertexCover();

    @Test
    public void testHappyCase() {
        Map<Integer, Set<Integer>> graph = Map.of(
                1, Set.of(),
                2, Set.of(1,3),
                3, Set.of(1),
                4, Set.of(3)
        );

        System.out.println(vertexCover.getMinimumCover(graph));
    }

    @Test
    public void testCycleCase() {
        Map<Integer, Set<Integer>> graph = Map.of(
                1, Set.of(2),
                2, Set.of(3),
                3, Set.of(1,4),
                4, Set.of(),
                5, Set.of()
        );

        System.out.println(vertexCover.getMinimumCover(graph));
    }
}
