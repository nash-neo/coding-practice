package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Flatten2DVector implements Iterator<Integer> {

    private List<List<Integer>> vec2d;

    private int i; //first level index of next element

    private int j; //second level index of next element

    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        i = 0;
        j = 0;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Integer result = vec2d.get(i).get(j);
            ++j; //increment j, no need to check if j is in bound as next call to hasNext will do
            return result;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        //regularize
        while(i < vec2d.size() && j >= vec2d.get(i).size()) {
            j = 0;
            ++i;
        }
        return i < vec2d.size(); // if i < vec2d.size(), then j is guaranteed to be in bound
    }

    @Override
    public void remove() {
        --j;
        //regularize index
        while (i >= 0 && j < 0) {
            j = vec2d.get(i).size()-1; //j has to be reset before --i
            --i;
        }
        if (i >= 0) { //valid
            vec2d.get(i).remove(j);
        }
        else {
            throw new IllegalStateException();
        }

    }

}
