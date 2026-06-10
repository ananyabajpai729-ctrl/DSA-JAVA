class Solution {
    public int helper(int[][] mat, int col){
        int maxAns = Integer.MIN_VALUE;
        int index = - 1;
        for(int i = 0 ; i< mat.length; i++){
            if(mat[i][col] > maxAns){
                maxAns = mat[i][col];
                index = i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int start =0;
        int end = m - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            int row = helper(mat, mid);

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = mid + 1 < m ? mat[row][mid +1] : Integer.MIN_VALUE;

            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[] {row, mid};
            }else if(left > mat[row][mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }
}
