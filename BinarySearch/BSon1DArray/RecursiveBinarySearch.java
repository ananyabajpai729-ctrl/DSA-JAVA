class Solution {
    public int recur(int[] nums, int start, int end, int target){
        if(start> end){
            return -1;
        }
        int mid = start + (end - start)/2;

        if(nums[mid] == target) return mid;
        if(nums[mid] < target){
            return recur(nums, mid+1, end, target);
        } else{
            return recur(nums, start, mid-1, target);
        }
        
    }
    public int search(int[] nums, int target) {
        return recur(nums, 0, nums.length - 1, target);
    }
}
