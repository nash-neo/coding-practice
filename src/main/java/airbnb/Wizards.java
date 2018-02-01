package airbnb;

//There are 10 wizards, 0-9, you are given a list that each entry is a list of wizards known by wizard.
//Define the cost between wizards and wizard as square of different of i and j.
//To find the min cost between 0 and 9.

import java.util.*;

public class Wizards {

    //edge cases: 1. end is unreachable from start, 2. there is a cycle, 3 multiple paths to end in the same level
    /**
     * using dijkstra shortest path
     * @param wizards list of wizard id to knowing wizards id, if w has no friend, the inner list is empty
     * @param start start wizard id
     * @param end ending wizard id
     * @return distance or -1 if end is not reachable from start
     */
    int calculateDistance(List<List<Integer>> wizards, int start, int end) {

        //in the order of square distance from start to current wizard
        Queue<Wizard> queue = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        Set<Integer> visited = new HashSet<>(); //visited represented shortest distance found

        Wizard w = new Wizard(start);
        w.distance = 0;
        queue.add(w);

        while (!queue.isEmpty()) {
            Wizard curr = queue.poll();
            if (curr.id == end) {
                return curr.distance;
            }
            if (visited.contains(curr.id)) {
                continue; //shortest distance for curr.id is already found, skip
            }
            visited.add(curr.id); //shortest path from start to curr.id is found
            for (Integer nextId : wizards.get(curr.id)) {
                if (visited.contains(nextId)) {
                    continue; //shortest distance for nextId is already found, skip
                }
                Wizard child = new Wizard(nextId);
                child.distance = curr.distance + (curr.id - nextId) * (curr.id - nextId);
                child.parentId = curr.id;
                queue.add(child);
            }
        }

        return -1; //the end wizard is not in the shortest path tree rooted from start wizard

    }

    private static class Wizard {
        int id;
        int distance;
        int parentId;
        public Wizard(int id) {
            this.id = id;
            distance = Integer.MAX_VALUE;
            parentId = -1;
        }
    }

}
