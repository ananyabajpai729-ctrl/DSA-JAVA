class Solution {
    public int floorSqrt(int n) {
      
      int start = 1;
      int end = n;
      long mid;
      int ans =0;
      while(start <= end){
        mid = start + (end - start)/2;

        if(mid * mid <= n){
            ans = (int)mid;
            start = (int)mid+1;
        }else{
            end = (int)mid - 1;
        }
      }
      return ans;
    }
}
