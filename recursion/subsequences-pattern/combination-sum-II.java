class Solution {
    List<List<Integer>> result= new ArrayList<>();
    public void solve(int index, int remaining, List<Integer> chosen, int[] candidates){
        if(remaining==0){
            result.add(new ArrayList<>(chosen));
            return;
        }
        for(int i = index; i< candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;

            if(candidates[i] > remaining) break;

            chosen.add(candidates[i]);

            solve(i + 1, remaining - candidates[i] , chosen, candidates);

            chosen.remove(chosen.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(0, target, new ArrayList<>(), candidates);
        return result;
    }
}
