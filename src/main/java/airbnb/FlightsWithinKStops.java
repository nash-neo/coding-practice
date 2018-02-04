package airbnb;


import java.util.*;

//given a list of flights(start, destination, cost), a start, a destination, a max number of stops,
//find the minimum cost from start to destination that takes at most K stops
//Assume for any pair (A,B) there is only one flight
//Assume there is no negative cost
//Could have cycle
public class FlightsWithinKStops {

    /**
     *
     * @param flights
     * @param start
     * @param dest
     * @param maxStops
     * @return
     */
    public List<String> minCost(List<Flight> flights, String start, String dest, int maxStops) {
        //convert list of flights to weighted edge directed graph,
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (Flight flight : flights) {
            graph.putIfAbsent(flight.from, new HashMap<>());
            graph.get(flight.from).put(flight.to, flight.cost);
        }
        //using DFS to search, prune if stops exceeds maxStops
        List<String> currPath = new ArrayList<>();
        currPath.add(start);

        Set<String> currPathSet = new HashSet<>();
        currPathSet.add(start);

        Path minPath = new Path(Double.MAX_VALUE, null);

        dfs(start, graph, currPath, currPathSet, 0, minPath, maxStops, dest);

        return minPath.path;
    }

    //using currPath is easier to write than prevPath
    private void dfs(String curr, Map<String, Map<String, Double>> graph,
                     List<String> currPath, Set<String> currPathSet, double currCost,
                     Path minPath,
                     int maxStops, String dest) {
        if (currPath.size() >= maxStops + 2 && !curr.equals(dest)) {
            return; //prune
        }
        if (curr.equals(dest)) {
            if (currCost < minPath.cost) {
                minPath.cost = currCost;
                minPath.path = new ArrayList<>(currPath);
            }
            return; //reach dest, assume cost is always positive, prune this seach path
        }
        //stops < maxStops and curr is not dest, keep searching
        for (String next : graph.getOrDefault(curr, Collections.emptyMap()).keySet()) {
            if (currPathSet.contains(next)) {
                continue; //skip since next is already in currpath
            }
            currPath.add(next);
            currPathSet.add(next);
            currCost += graph.get(curr).get(next);

            dfs(next, graph, currPath, currPathSet, currCost, minPath, maxStops, dest);
            //revert
            currPath.remove(currPath.size()-1);
            currPathSet.remove(next);
            currCost -= graph.get(curr).get(next);
        }
        return;
    }

    static class Path {
        double cost;
        List<String> path;
        Path(double cost, List<String> path) {
            this.cost = cost;
            this.path = path;
        }
    }


    static class Flight {
        String from;
        String to;
        double cost;
        public Flight(String from, String to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
