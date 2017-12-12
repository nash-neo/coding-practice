package airbnb;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DisplayPagesTest {

    private DisplayPages displayPages = new DisplayPages();

    @Test
    public void test() {
        List<Integer> ids = Arrays.asList(1,1,1,1,1,2,2,2,2,2);
        System.out.println(displayPages.paginate(ids, 3));
    }

    @Test
    public void test1() {
        List<Integer> ids = Arrays.asList(1,1,1,1,1,2,3,4,5,6);
        System.out.println(displayPages.paginate(ids, 3));
    }
}
