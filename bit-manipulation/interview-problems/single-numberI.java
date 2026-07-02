class Solution {
    public int singleNumber(int[] nums) {
        int xorr = nums[0];

        for(int i = 1; i< nums.length; i++){
            xorr ^= nums[i];
        }
        return xorr;
    }
}
