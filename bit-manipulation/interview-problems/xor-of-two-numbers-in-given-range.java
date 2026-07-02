class Solution {
    private int xorTillN(int N){
        if(N%4 == 0) return N;
        if(N%4 == 1) return 1;
        if(N%4 == 2) return N+1;
        return 0;
    }
    public int findRangeXOR(int l, int r) {
        return xorTillN(r) ^ xorTillN(l -1);
    }
}
