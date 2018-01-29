package airbnb;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Flatten2DVectorIterator implements Iterator<Integer> {

    private Iterator<List<Integer>> rowIter;

    private Iterator<Integer> colIter;

    public Flatten2DVectorIterator(List<List<Integer>> vec2d) {
        rowIter = vec2d.iterator();
        if (rowIter.hasNext()) {
            colIter = rowIter.next().iterator();
        }
        else {
            colIter = null;
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return colIter.next();
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext() {
        if (colIter == null) {
            return false;
        }
        while (!colIter.hasNext() && rowIter.hasNext()) {
            colIter = rowIter.next().iterator();
        }
        return colIter.hasNext();
    }

    @Override
    public void remove() {
        colIter.remove();
    }
}
