class Solution {
    public int[] divisors(int n) {
        List<Integer> ansList = new ArrayList<>();
        for(int i = 1; i*i <= n; i++){
            if(n %i == 0){
                ansList.add(i);

                if((n/i) != i){
                    ansList.add(n/i);
                }
            } 
        }
        int[] ans = new int[ansList.size()];
        for(int i = 0; i< ansList.size(); i++){
            ans[i] = ansList.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
}
