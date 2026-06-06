class Solution {
    public boolean divisionSum(int[] nums, int threshold, int divisor){
        long sum = 0;
        for(int j = 0; j<nums.length ; j++){
            sum += (long)Math.ceil((double)nums[j]/ divisor);
        }
        if(sum> threshold){
            return false;
        }else{
            return true;
        }
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int maxVal = 0;
        for(int i = 0; i< nums.length; i++){
            if(maxVal < nums[i]) maxVal = nums[i];
        }

        int start = 1;
        int end = maxVal;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(divisionSum(nums, threshold, mid)){
                ans= mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        return ans;
    }
}
