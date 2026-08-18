class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int fresh = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1,0}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        while(!q.isEmpty() && fresh > 0){
            int k = q.size();

            for(int i = 0; i < k; i++){
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];
                for(int[] d: dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nr <grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                    
                }
            }
            minutes++;
        }

        return fresh == 0 ?minutes: -1;
    }
}
