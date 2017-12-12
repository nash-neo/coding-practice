package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        ListIterator<Integer> iter = list.listIterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        iter.remove();
        System.out.println(list);
    }
}
