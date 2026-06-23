class Solution {
    public double helper(double x, long N){
        if(N == 0) return 1.0;
        if(N== 1) return x;
        
        if(N %2 == 0){
            return helper(x*x, N/2);
        }
        return x* helper(x, N-1);
    }
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            return 1.0/helper(x, -N);
        }

        return helper(x, N);
    }
}
