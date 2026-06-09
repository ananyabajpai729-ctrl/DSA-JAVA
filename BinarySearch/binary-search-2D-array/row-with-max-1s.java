class Solution {
    public int lowerBound(int[] arr, int m){
        int start = 0;
        int end= m - 1;
        int ans = m;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] >= 1){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public int rowWithMax1s(int[][] mat) {
       int count_max = 0;
       int m = mat[0].length;
       int ans = -1;
       if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return -1;
       }
       for(int i = 0; i< mat.length; i++){
        int count = m- lowerBound(mat[i] ,m);
        if(count > count_max){
            count_max = count;
            ans = i;
        }
       }

       return ans;    
    }
}
