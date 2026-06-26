class Solution {
    private void solve(int[] nums, List<Integer> ans, int index, int sum){
        if(index == nums.length){
            ans.add(sum);
            return;
        }
        solve(nums, ans, index + 1, sum + nums[index]);

        solve(nums, ans, index + 1, sum);
    }
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        solve(nums, ans, 0, 0);
        return ans;
    }
}
