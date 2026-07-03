class Solution {
        private int[] sieve(int max_val){
            int[] spf = new int[max_val + 1];
            Arrays.fill(spf, 1);
            
            for(int i = 2; i<= max_val; i++){
                if(spf[i] == 1){
                    for(int j = i; j <= max_val; j+=i){
                        if(spf[j] == 1) spf[j] = i;
                    }
                }
            }

            return spf;
        }
        public List<List<Integer>> primeFactors(int[] queries) {
            List<List<Integer>> ans = new ArrayList<>();

            int maxNum = queries[0];
            for(int i = 1; i< queries.length; i++){
                if(maxNum < queries[i]) maxNum = queries[i];
            }
            int[] spf = sieve(maxNum);

            for(int i = 0; i< queries.length; i++){
                List<Integer> level = new ArrayList<>();
                int num = queries[i];
                while(spf[num] != 1){
                    level.add(spf[num]);
                    num = num / spf[num];
                }
                ans.add(level);
            }

            return ans;
        }
}
