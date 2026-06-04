class Solution {
    public long totalHours(int[] piles, int speed){
        long tHours=0;
        for(int j = 0; j < piles.length; j++){
        // Cast piles[j] to double first, then divide
        tHours += (int) Math.ceil((double) piles[j] / speed);
        }
        return tHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 0;

        for(int i = 0; i< piles.length ; i++){
            if(piles[i] > maxVal){
                maxVal = piles[i];
            }
        }
        int ans = 0;
        int start = 1;
        int end = maxVal;
        while(start <= end){
            int mid = start + (end - start)/2;
            long totalHours = totalHours(piles, mid);

            if(totalHours <= h){
                ans = mid;
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
