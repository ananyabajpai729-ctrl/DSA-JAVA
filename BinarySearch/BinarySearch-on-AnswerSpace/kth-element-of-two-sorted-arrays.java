class Solution {
    public int kthElement(int[] a, int[] b, int k) {
      int m = a.length;
      int n = b.length;

      if(m> n){
        return kthElement(b, a, k);
      }

      int left = k;
      int low = Math.max(0, k-n);
      int high = Math.min(k, m);

      while(low <= high){
        int mid1 = low + (high - low)/2;
        int mid2 = left - mid1;

        int l1 = (mid1  > 0 )? a[mid1 - 1]: Integer.MIN_VALUE;
        int l2 = (mid2 > 0)? b[mid2 - 1]: Integer.MIN_VALUE;
        int r1 = (mid1 < m)? a[mid1] : Integer.MAX_VALUE;
        int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;

        if(l1 <= r2 && l2 <= r1){
            return Math.max(l1, l2);
        }else if(l1 > r2){
            high = mid1 - 1;
        }else{
            low = mid1 + 1;
        }
      }
      return -1;
    }
}
