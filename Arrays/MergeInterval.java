class Solution {
    public int[][] merge(int[][] intervals) {
        // Handle empty or single interval cases safely
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        
        // 2. Initialize with the first interval
        int[] currentInterval = intervals[0];
        ans.add(currentInterval);

        // 3. Iterate through all intervals to find overlaps
        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextStart <= currentEnd) {
                // Overlap found: Update the end of the current interval in-place
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: Move to the next interval and add it to the list
                currentInterval = intervals[i];
                ans.add(currentInterval);
            }
        }

        // 4. Convert the dynamic list back to a 2D array
        return ans.toArray(new int[ans.size()][]);
    }
}
