package practice;

import java.util.ArrayList;
import java.util.List;

public class PermuteListOfList {

    List<List<Character>> permute(List<List<Character>> lists) {
        List<List<Character>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), lists, result);
        return result;
    }

    void backtrack(List<Character> partial, List<List<Character>> input, List<List<Character>> result) {
        if (partial.size() == input.size()) {
            result.add(new ArrayList<>(partial));
            return;
        }
        //else partial.size() < input.size()
        int k = partial.size(); //next is kth list in input
        for (Character ch : input.get(k)) {
            partial.add(ch);
            backtrack(partial, input, result);
            partial.remove(k); //remove the last
        }
    }
}
