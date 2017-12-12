package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    //We could use a greedy strategy to always choose the non repeated task which has a high remaining count
    //it is like a pagination, so an equivalent question is to ask how many pages (pages.size()-1) idle cycle
    //a max priority queue for fetching task with max count, a list for storing added tasks which will be added in the next cycle
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for(char t : tasks) {
            ++counter[t-'A'];
        }
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < counter.length; ++i) {
            if (counter[i] > 0)
                maxQueue.offer(counter[i]);
        }
        int output = 0;
        while(!maxQueue.isEmpty()) {
            int slots = n;
            List<Integer> used = new ArrayList<>();
            while (slots > 0 && !maxQueue.isEmpty()) {
                int count = maxQueue.poll();
                --count;
                if (count > 0) {
                    used.add(count);
                }
                --slots;
            }
            for (Integer i : used) {
                maxQueue.offer(i);
            }
            if (maxQueue.isEmpty()) {
                output += (n-slots);
            }
            else {
                output += n;
            }
        }
        return output;
    }
}