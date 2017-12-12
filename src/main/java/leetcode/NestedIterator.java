package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class NestedInteger {

    private Integer integer;

    private List<NestedInteger> list;

    public NestedInteger(Integer integer) {
        this.integer = integer;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    public boolean isInteger(){
        return integer != null;
    }

    public Integer getInteger(){
        return integer;
    }

    public List<NestedInteger> getList(){
        return list;
    }
}
public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;

    private Integer nextInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        nextInt = null;
        for (int i = nestedList.size()-1; i >= 0; --i) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        Integer result = null;
        if (hasNext()){
            result = nextInt;
            nextInt = null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (nextInt != null) {
            return true;
        }
        //else find nextInt
        while(!stack.isEmpty()) {
            NestedInteger next = stack.pop();
            if (next.isInteger()) {
                nextInt =  next.getInteger();
                break;
            }
            else {
                List<NestedInteger> nestedList = next.getList();
                for (int i = nestedList.size()-1; i >= 0; --i) {
                    stack.push(nestedList.get(i));
                }
            }
        }
        return nextInt != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */