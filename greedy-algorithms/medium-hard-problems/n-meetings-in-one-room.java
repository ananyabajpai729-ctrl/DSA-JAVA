class Solution {
    public int maxMeetings(int[] start, int[] end) {
       ArrayList<int[]> meetings = new ArrayList<>();

       for(int i = 0; i < start.length ; i++){
        meetings.add(new int[] {end[i], start[i], i + 1});
       }

       meetings.sort(Comparator.comparingInt(a -> a[0]));

       int count = 0;

       int lastEnd = -1;

       for(int[] m : meetings){
            if(m[1] > lastEnd){
                count++;
                lastEnd = m[0];
            }
       }

        return count;
    }
}
