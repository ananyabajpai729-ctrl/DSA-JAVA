class Solution {
    public boolean canJump(int[] nums) {
        int i=0;
        int limit=0;
        while(i< nums.length){
            if(i> limit){
                return false;
            }
            limit= Math.max(limit, i+ nums[i]);
            i++;
            
        }
        return true;
    }
}
