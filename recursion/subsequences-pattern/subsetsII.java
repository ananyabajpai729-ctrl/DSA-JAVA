class Solution {
    private void solve(List<List<Integer>> ans, List<Integer> subset, int index, int[] nums){

        ans.add(new ArrayList<>(subset));

        for(int i = index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i -1]) continue;
            subset.add(nums[i]);
            solve(ans, subset, i + 1, nums);

            subset.remove(subset.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
}
