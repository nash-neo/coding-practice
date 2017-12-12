package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> partial, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(partial));
            return;
        }
        //include nums[i]
        partial.add(nums[i]);
        backtrack(nums, i+1, partial, result);
        partial.remove(partial.size()-1);
        //exclude nums[i]
        backtrack(nums, i+1, partial, result);
    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
//        list.add(new ArrayList<>(tempList));
//        for(int i = start; i < nums.length; i++){
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }
}
