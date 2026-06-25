class Solution {
    static int count = 0;
    public void helper(int[] nums, int k, int index, int sum){
        if(index == nums.length){
            if(sum == k){
                count++;
            }
            return;
        }

        helper(nums, k, index + 1, sum);

        helper(nums, k, index + 1, sum+ nums[index]);
    }
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        count = 0;
        helper(nums, k, 0 ,0);
        return count;
    }
}
