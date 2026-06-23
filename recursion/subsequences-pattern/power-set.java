import java.util.*;
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int[] nums, int index, List<Integer> subset){
        if(index == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        //we include the current element of nums
        subset.add(nums[index]);
        helper(nums, index + 1, subset);

        // we don't include the current element of nums
        subset.remove(subset.size() - 1);//backtracking
        helper(nums, index + 1, subset);
    }
    public List<List<Integer>> powerSet(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return ans;
    }
}
