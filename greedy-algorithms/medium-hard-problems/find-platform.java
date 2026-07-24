class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int i = 0;
        int j = 0;
        int platforms = 1;
        int count = 0;

        while(i < n && j <n){
            if(Arrival[i] <= Departure[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            platforms = Math.max(platforms, count);
        }
        return platforms;
    }
}
