class Solution {
    public boolean isSafe(char[][] board, int row, int col, int n){
        //in column
        for(int i = 0; i< row; i++){
            if(board[i][col] =='Q') return false;
        }
        //upper left
        for(int i = row, j = col; i >= 0 && j>=0 ; i--, j--){
            if(board[i][j] == 'Q') return false;
        }
        //upper right
        for(int i = row, j = col; i>= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, ans, n);
        return ans;
    }

    public void solve(char[][] board, int rowNumber, List<List<String>> ans, int n){
        if(rowNumber == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i< n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int j = 0; j< n; j++){
            if(isSafe(board, rowNumber, j, n)){
                board[rowNumber][j] = 'Q';
                solve(board, rowNumber + 1, ans, n);
                board[rowNumber][j] = '.';
            }
        }
    }
}
