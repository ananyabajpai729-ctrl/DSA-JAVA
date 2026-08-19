class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        //upper row
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O'){
                board[0][i] = 'S';
                q.add(new int[]{0, i});
            }
        }

        //left boundary
        for(int i = 1; i < m; i++){
            if(board[i][0] == 'O'){
                board[i][0] = 'S';
                q.add(new int[] {i, 0});
            }
        }

        //right boundary
        for(int i = 1; i < m; i++){
            if(board[i][n -1] == 'O'){
                board[i][n-1] = 'S';
                q.add(new int[]{i, n-1});
            }
        }

        //bottom row
        for(int i = 1; i < n - 1; i++){
            if(board[m- 1][i] == 'O'){
                board[m- 1][i] = 'S';
                q.add(new int[]{m-1, i});
            }
        }

        while(!q.isEmpty()){
            int[] pos = q.poll();

            for(int[] d: dirs){
                int nr = pos[0] + d[0];
                int nc = pos[1] + d[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc <n && board[nr][nc] == 'O'){
                    board[nr][nc] = 'S';
                    q.add(new int[]{nr, nc});
                }
            }
        }

        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
