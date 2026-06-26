class Solution {
    private void helper(int index, int remaining, int k, List<List<Integer>> ans, List<Integer> current){
        if(remaining == 0 && current.size() == k){
            ans.add(new ArrayList<>(current));
            return;
        }
        if (remaining <= 0 || current.size() > k) return;

        for(int i = index; i<= 9; i++){
            if(i <= remaining){
                current.add(i);
                helper(i + 1, remaining - i,k,  ans, current);
                current.remove(current.size() - 1);
            }else{
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, n, k, ans, new ArrayList<>());
        return ans;
    }
}
