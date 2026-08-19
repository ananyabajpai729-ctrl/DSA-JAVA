class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = -1; 
                }
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return mat;
    }
}
