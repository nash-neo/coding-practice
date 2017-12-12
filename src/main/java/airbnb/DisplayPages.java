package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DisplayPages {

    //O(nlogn)
    public List<List<Integer>> paginate(List<Integer> ids, int pageSize) {
        //count frequency
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (Integer id : ids) {
            hashmap.put(id, hashmap.getOrDefault(id, 0)+1);
        }
        //sort based on frequency, frequency could be same, use priority queue
        Queue<Id> queue = new PriorityQueue<>((a,b) -> b.count - a.count); // decreasing order
        for (Integer id : hashmap.keySet()) {
            queue.offer(new Id(id, hashmap.get(id)));
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> page = new ArrayList<>();
        List<Id> tmp = new ArrayList<>(); //holding used Id in current page
        for (int i = 0; i < ids.size(); ++i) {
            if (i % pageSize == 0) {
                page = new ArrayList<>();
            }
            if (queue.isEmpty()) {
                queue.addAll(tmp);
                tmp.clear();
            }
            Id id = queue.poll();
            page.add(id.id);
            --id.count;
            if (id.count != 0) {
                tmp.add(id);
            }
            if (page.size() == pageSize) {
                result.add(page);
                queue.addAll(tmp);
                tmp.clear();
            }
        }
        if (!page.isEmpty()) {
            result.add(page);
        }
        return result;
    }

    private static class Id {
        int id;
        int count;
        public Id(int id, int count) {
            this.id = id;
            this.count = count;
        }
    }
}
