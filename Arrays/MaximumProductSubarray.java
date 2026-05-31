
class Solution {
    public int maxProduct(int[] nums) {
        int minPro = nums[0];
        int maxPro = nums[0];
        int res = nums[0];

        for(int i = 1; i<nums.length; i++){
            int curr = nums[i];

            if(curr < 0){
                int temp = minPro;
                minPro = maxPro;
                maxPro = temp;
            }

            maxPro = Math.max(curr, maxPro*curr);
            minPro = Math.min(curr, minPro*curr);

            res = Math.max(maxPro, res);
        }

        return res;
    }
}
