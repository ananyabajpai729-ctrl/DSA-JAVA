class Solution {
    private boolean[] sieve(int n){
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = sieve(n);
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i] == true) count++;
        }
        return count;
    }
}
