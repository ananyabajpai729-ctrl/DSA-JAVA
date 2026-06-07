class Solution {
    public int countPartitions(int[] nums, int maxSum){
        long subarraySum = 0;
        int partitions = 1;

        for(int i = 0; i < nums.length; i++){
            if(subarraySum + nums[i] <= maxSum){
                subarraySum += nums[i];
            }else{
                partitions++;
                subarraySum = nums[i];
            }
        }
        return partitions;
    }
    public int splitArray(int[] nums, int k) {
        int start = Arrays.stream(nums).max().getAsInt();
        int end = Arrays.stream(nums).sum();

        while(start <= end){
            int mid = start + (end - start)/2;
            if(countPartitions(nums, mid) <= k){
                end= mid -1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
