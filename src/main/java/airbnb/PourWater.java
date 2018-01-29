package airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PourWater {

    /**
     * check if the water can be placed in the left
     * if not check if the water can be placed in the right
     * if not, place in the original position
     * @param heights
     * @param pos 0 based
     * @param count
     * @return water
     */
    public List<Integer> pourWater(List<Integer> heights, int pos, int count) {
        //assume heights is not null or empty
        if (heights == null || heights.isEmpty() || pos < 0 || pos >= heights.size() || count < 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> water = new ArrayList<>(Collections.nCopies(heights.size(),0));
        while (count > 0) {
            int currPos = pos;
            //check the height of currPos vs currPos-1
            while (currPos > 0
                    && heights.get(currPos) + water.get(currPos) >= heights.get(currPos-1) + water.get(currPos-1)) {
                --currPos;
            }
            // cannot found a lower position in the left, try right
            if (currPos == pos) {
                //check the height of currPos vs currPos+1
                while (currPos < heights.size() -1
                        && heights.get(currPos) + water.get(currPos) >= heights.get(currPos+1) + water.get(currPos+1)) {
                    ++currPos;
                }
            }
            water.set(currPos, water.get(currPos)+1);
            --count;
        }
        return water;
    }

    //pouring in the original position if there is a flat
    public List<Integer> pourWater2(List<Integer> heights, int pos, int count) {
        //assume heights is not null or empty
        if (heights == null || heights.isEmpty() || pos < 0 || pos >= heights.size() || count < 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> water = new ArrayList<>(Collections.nCopies(heights.size(),0));
        while (count > 0) {
            int currPos = pos;
            //check the height of currPos vs currPos-1
            while (currPos > 0
                    && heights.get(currPos) + water.get(currPos) >= heights.get(currPos-1) + water.get(currPos-1)) {
                --currPos;
            }
            // cannot found a lower position in the left, try right
            if (currPos == pos ||
                    heights.get(currPos) + water.get(currPos) == heights.get(pos) + water.get(pos)) {
                //check the height of currPos vs currPos+1
                while (currPos < heights.size() -1
                        && heights.get(currPos) + water.get(currPos) >= heights.get(currPos+1) + water.get(currPos+1)) {
                    ++currPos;
                }
            }
            //unnecessary, if there is a flat, place to original position
            if (heights.get(currPos) + water.get(currPos) == heights.get(pos) + water.get(pos)) {
                currPos = pos;
            }
            water.set(currPos, water.get(currPos)+1);
            --count;
        }
        return water;
    }

    //the boundary does not hold water
    public List<Integer> pourWater3(List<Integer> heights, int pos, int count) {
        //assume heights is not null or empty
        if (heights == null || heights.isEmpty() || pos < 0 || pos >= heights.size() || count < 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> water = new ArrayList<>(Collections.nCopies(heights.size(),0));
        while (count > 0) {
            int currPos = pos;
            //check the height of currPos vs currPos-1
            while (currPos == 0
                    || currPos > 0
                        && heights.get(currPos) + water.get(currPos) >= heights.get(currPos-1) + water.get(currPos-1)) {
                --currPos;
            }
            // cannot found a lower position in the left, try right
            if (currPos == pos || heights.get(currPos) + water.get(currPos) >= heights.get(pos) + water.get(pos) ) {
                //check the height of currPos vs currPos+1
                while (currPos == heights.size() -1 ||
                        currPos < heights.size() -1
                            && heights.get(currPos) + water.get(currPos) >= heights.get(currPos+1) + water.get(currPos+1)) {
                    ++currPos;
                }
            }
            if (currPos >= 0 && currPos < heights.size()) {
                water.set(currPos, water.get(currPos) + 1);
            }
            //else not add water as it falls off the boundary
            --count;
        }
        return water;
    }

    public void print(List<Integer> heights, List<Integer> water) {
        if (heights == null || heights.isEmpty() || water == null || water.isEmpty()
                || heights.size() != water.size()) {
            throw new IllegalArgumentException();
        }
        int maxHeight = 0;
        for (int i = 0; i < heights.size(); ++i) {
            maxHeight = Math.max(maxHeight, heights.get(i) + water.get(i));
        }
        for (int height = maxHeight; height > 0; --height) {
            for (int i = 0; i < heights.size(); ++i) {
                if (heights.get(i) + water.get(i) < height) {
                    System.out.print(' '); //whitespace
                }
                else if (heights.get(i) >= height) {
                    System.out.print('*');
                }
                else { //heights.get(i) < height && heights.get(i)+water.get(i) >= height
                    System.out.print('w');
                }
            }
            System.out.println();
        }
    }

}
