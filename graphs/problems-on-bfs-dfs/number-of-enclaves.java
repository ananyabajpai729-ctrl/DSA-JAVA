class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        //upper row
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1){
                q.add(new int[]{0, i});
                grid[0][i] = -1;
            }
        }

        //right boundary
        for(int i = 1; i < m; i++){
            if(grid[i][n-1] == 1){
                q.add(new int[]{i, n - 1});
                grid[i][n-1] = -1;
            }
        }

        //left boundary
        for(int i = 1; i < m; i++){
            if(grid[i][0] == 1){
                q.add(new int[]{i, 0});
                grid[i][0] = -1;
            }
        }

        //bottom row
        for(int i = 1; i < n - 1; i++){
            if(grid[m-1][i] == 1){
                q.add(new int[]{m-1, i});
                grid[m-1][i] = -1;
            }
        }

        while(!q.isEmpty()){
            int[] pos = q.poll();

            for(int[] d: dirs){
                int nr = pos[0] + d[0];
                int nc = pos[1] + d[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = -1;
                }
            }
        }
        int ans = 0;
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }
}
