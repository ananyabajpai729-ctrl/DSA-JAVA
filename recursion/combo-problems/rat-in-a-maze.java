class Solution {
    public void helper(int[][] grid, List<String> ans, int i, int j, StringBuilder path){

        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j] != 1){
            return;
        }

        if(i== grid.length-1 && j == grid[0].length-1){
            ans.add(path.toString());
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = -1;

        path.append('D');
        helper(grid, ans, i+1, j, path);
        path.setLength(path.length() - 1);

        path.append('U');
        helper(grid, ans, i-1, j, path);
        path.setLength(path.length() - 1);

        path.append('R');
        helper(grid, ans, i, j+1, path);
        path.setLength(path.length() - 1);

        path.append('L');
        helper(grid, ans, i, j-1, path);
        path.setLength(path.length() - 1);

        grid[i][j] = temp;
    }
    public List<String> findPath(int[][] grid) {
        List<String> ans = new ArrayList<>();
        helper(grid, ans, 0, 0, new StringBuilder());
        return ans;
    }
}
