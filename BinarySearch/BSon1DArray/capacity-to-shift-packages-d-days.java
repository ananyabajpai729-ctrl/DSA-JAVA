class Solution {
    public boolean reqDays(int[] weights, int days, int capacity){
        int totalDays = 1;
        int k = 0;
        for(int i = 0; i< weights.length; i++){
            if(weights[i] <= capacity - k){
                k+= weights[i];
            }else{
                k = weights[i];
                totalDays++;
            }
        }
        return totalDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight= 0;
        int totalWeight = 0;
        for(int i = 0; i< weights.length; i++){
            if(maxWeight < weights[i]) maxWeight = weights[i];
            totalWeight+= weights[i];
        }
        int start = maxWeight;
        int end = totalWeight;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(reqDays(weights, days, mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
