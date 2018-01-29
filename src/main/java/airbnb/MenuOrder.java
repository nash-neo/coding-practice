package airbnb;

import java.util.ArrayList;
import java.util.List;

// http://xkcd.com/287/

// Example, target 15.05

// "Fruit": 2.15
// "Fries": 2.75
// "Salad": 3.35
// "Wings": 3.55
// "Mozzarella": 4.20
// "Plate": 5.80

// [2.15, 2.75, 3.35, 3.55, 4.2, 5.8]

// could be duplicated

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class MenuOrder {

    public static List<List<Integer>> order(List<Double> pricesD, double targetD) {
        List<Integer> prices = new ArrayList<>();
        for (Double priceD : pricesD) {
            prices.add((int)(priceD*100));
        }
        int target = (int)(targetD * 100);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), target, 0, prices, result);
        // Set<List<Integer>> set = new HashSet<>();
        // for (List<Integer> solution : result) {
        // solution.sort((a,b) -> a-b);
        // set.add(solution);
        // }
        // return new ArrayList<>(set);
        return result;
    }

    private static void backtrack(List<Integer> partial, int target, int i, List<Integer> prices, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(partial));
            return;
        }
        if (i == prices.size()) {
            return;
        }
        if (target < 0) {
            return;
        }
        //target > 0
        // for (int i = 0; i < prices.size(); ++i) {
        // partial.add(i);
        // backtrack(partial, target - prices.get(i), prices, result);
        // partial.remove(partial.size()-1); //remove the last element
        // }

        //first use ith item
        partial.add(i);
        backtrack(partial, target-prices.get(i), i, prices, result);
        partial.remove(partial.size()-1);
        //second not use ith item
        backtrack(partial, target, i+1, prices, result);
        return;
    }

    public static void main(String[] args) {
        List<Double> pricesD = new ArrayList<>();
        // [2.15, 2.75, 3.35, 3.55, 4.2, 5.8]
        pricesD.add(2.15); //2.15 * 7 = 15.05
        pricesD.add(2.75);
        pricesD.add(3.35);
        pricesD.add(3.55);
        pricesD.add(4.2);
        pricesD.add(5.8);
        double targetD = 15.05;
        List<List<Integer>> result = order(pricesD, targetD);
        for (List<Integer> solution : result) {
            double sum = 0;
            System.out.println(solution);
            for (Integer i : solution) {
                sum += pricesD.get(i);
            }
            System.out.println(sum);
        }
    }
}