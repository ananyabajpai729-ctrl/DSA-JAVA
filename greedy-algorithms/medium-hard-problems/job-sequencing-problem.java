class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs, (a,b) -> Integer.compare(b[2], a[2]));

        int maxTime = 0;
        for(int i = 0; i < Jobs.length; i++){
            maxTime = Math.max(maxTime, Jobs[i][1]);
        }

        int count = 0;
        int profit = 0;

        int[] schedule = new int[maxTime+1];
        Arrays.fill(schedule, -1);

        for(int i = 0; i < Jobs.length; i++){
            for(int j = Jobs[i][1] ; j > 0; j--){
                if(schedule[j] == -1){
                    schedule[j] = i;
                    profit += Jobs[i][2];
                    count++;
                    break;
                }
            }
        }

        return new int[] {count, profit};
    }
}
