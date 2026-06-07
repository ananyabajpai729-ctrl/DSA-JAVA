class Solution {
    public boolean canPlace(int[] nums, int k, int d){
        int count = 1;
        int lastPos= nums[0];
        for(int i = 1; i<nums.length; i++){
            if(nums[i] - lastPos >= d){
                count++;
                lastPos = nums[i];
            }

            if(count >= k) return true;
        }
        return false;
    }
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int maxDist = nums[nums.length - 1] - nums[0];
        int ans = 0;
        int start = 1;
        int end = maxDist;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(canPlace(nums, k, mid)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return ans;
    }
}
