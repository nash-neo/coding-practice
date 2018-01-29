package airbnb;

public class PourWaterLeetCode {

    public int[] pourWater(int[] heights, int V, int K) {
        int n = heights.length;
        //for each drop, fill in the best position according to the rule
        for (int i = 0; i < V; ++i) {
            int bestIndex = findBestLeft(heights, K);
            if (bestIndex == K) {
                bestIndex = findBestRight(heights, K);
            }
            heights[bestIndex] += 1;
        }
        return heights;
    }

    //the following method could be simplied using delta = 1 or -1;
    private int findBestLeft(int[] heights, int K) {
        int bestIndex = K;
        int i = K;
        while(i > 0 && heights[i-1] <= heights[i]) {
            if (heights[i-1] < heights[i]) {
                bestIndex = i-1;
            }
            --i;
        }
        return bestIndex;
    }

    private int findBestRight(int[] heights, int K) {
        int bestIndex = K;
        for (int i = K; i < heights.length-1 && heights[i+1] <= heights[i]; ++i) {
            if (heights[i+1] < heights[i]) {
                bestIndex = i+1;
            }
        }
        return bestIndex;
    }
}