class Solution {
    public boolean isPossible(int[] bloomDay, int m, int k, int day){
        int count = 0;
        int bouquets = 0;
        for(int j = 0; j< bloomDay.length; j++){
            if(bloomDay[j] <= day){
                count++;
                if(count == k){
                    count = 0;
                    bouquets++;
                }
            }else{
                count = 0;
            }
        }

        return bouquets >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long) m * k;
        if (totalFlowers > bloomDay.length) return -1;
        int maxDay = 0;
        int minDay = Integer.MAX_VALUE;
        for(int i = 0; i<bloomDay.length; i++){
            maxDay = Math.max(maxDay, bloomDay[i]);
            minDay = Math.min(minDay, bloomDay[i]);
        }

        int start = minDay;
        int end = maxDay;
        int ans = 0;
        while(start<= end){
            int mid = start + (end - start)/2;
            boolean status = isPossible(bloomDay, m, k , mid);
            if(status == true){
                ans = mid;
                end = mid-1;
            }else{
                start = mid +1;
            }
        }

        return ans;

    }
}
