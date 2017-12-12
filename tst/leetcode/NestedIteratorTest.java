package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class NestedIteratorTest {

    NestedIterator nestedIterator;

    @Test
    public void test() {
        NestedInteger i1 = new NestedInteger(1);
        NestedInteger i2 = new NestedInteger(2);
        NestedInteger l1 = new NestedInteger(Arrays.asList(i1,i1));
        NestedInteger l2 = new NestedInteger(Arrays.asList(l1,i2,l1));
        nestedIterator = new NestedIterator(l2.getList());
        while(nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }

    }
}
