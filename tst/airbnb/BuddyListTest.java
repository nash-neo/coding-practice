package airbnb;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class BuddyListTest {

    private BuddyList buddyList = new BuddyList();

    @Test
    public void test0() {
        List<String> myList = List.of("a", "b", "c");
        Map<String, List<String>> buddyLists = Map.of("Nash", List.of("a", "b", "d"),
                "Neo", List.of("a", "c", "e", "f"));
        System.out.println(buddyList.sortBySimilarity(myList, buddyLists));
        System.out.println(buddyList.getRecommendations(myList, buddyLists, 2));
    }
}
