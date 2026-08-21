class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0,1}, {0, -1}};
        int count = 0;
        for(int i=0; i < grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';
                    count++;
                }
                while(!q.isEmpty()){
                    int[] cell = q.poll();
                    int r = cell[0];
                    int c = cell[1];

                    for(int[] d : dirs){
                        int nr = r+ d[0];
                        int nc = c+ d[1];

                        if(nr>= 0 && nc>= 0 && nr< grid.length && nc < grid[0].length && grid[nr][nc] == '1'){
                            q.add(new int[]{nr, nc});
                            grid[nr][nc] = '0';
                        }
                    }
                    
                }
            }
        }
        return count;
    }
}
