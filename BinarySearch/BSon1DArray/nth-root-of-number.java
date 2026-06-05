class Solution {
    public int NthRoot(int N, int M) {
        int start = 1;
        int end = M;

        while(start <= end){
            int mid = start + (end - start)/2;
            long ans = 1;
            for (int i = 0; i < N; i++) {
                ans *= mid;
                if (ans > M) break;
            }
            if(ans == M){
                return mid;
            }
            if(ans< M){
                start = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
