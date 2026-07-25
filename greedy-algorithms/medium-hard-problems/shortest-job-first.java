class Solution {
    public long solve(int[] bt) {
        Arrays.sort(bt);
        long sum = 0;
        long waitingTime = 0;

        for(int i = 1; i < bt.length; i++){
            waitingTime += bt[i-1];
            sum += waitingTime;
        }

        return (long) Math.floor(sum / bt.length);
    }
}
