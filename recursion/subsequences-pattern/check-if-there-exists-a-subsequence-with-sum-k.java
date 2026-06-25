class Solution {
    public boolean helper(int[] nums, int k, int index){
        if(k==0) return true;
        if(index == nums.length) return k==0;
        
        return helper(nums, k - nums[index], index + 1) || helper(nums, k , index + 1);
    }
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return helper(nums, k, 0);
    }
}
