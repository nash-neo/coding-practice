package airbnb;

import org.junit.Test;

import java.util.List;

public class PreferenceListTest {

    private PreferenceList preferenceList = new PreferenceList();


    //input: [[3, 5, 7, 9], [2, 3, 8], [5, 8]]  output: [2, 3, 5, 8, 7, 9]
    @Test
    public void test() {
        List<List<Integer>> preferences = List.of(
                List.of(3,5,7,9),
                List.of(2,3,8),
                List.of(5,8)
        );

        System.out.println(preferenceList.calculatePreferenceList(preferences));
    }
}
