class Solution {
    private boolean isSafe(char[][] board, int row, int col, int num){
        //checking the row
        for(int i = 0; i< board[0].length; i++){
            if(board[row][i] ==(char)(num + '0') ) return false;
        }

        //checking the column
        for(int i = 0; i< board.length; i++){
            if(board[i][col] == (char)(num + '0')) return false;
        }

        //checking sub-box
        int boxRow = 3*(row/3);
        int boxCol = 3*(col/3);

        for(int i = boxRow; i< boxRow + 3; i++){
            for(int j = boxCol; j < boxCol + 3; j++){
                if(board[i][j] == (char)(num + '0')) return false;
            }
        }

        return true;
    }
    private boolean solve(char[][] board){
        for(int i = 0; i< 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(int num = 1; num<= 9; num++){
                        if(isSafe(board, i, j, num)){
                            board[i][j] = (char)(num + '0');

                            if(solve(board)) return true;

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
