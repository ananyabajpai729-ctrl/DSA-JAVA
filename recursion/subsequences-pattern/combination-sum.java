class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int index, int remaining, List<Integer> chosen, int[] candidates) {
        if(index == candidates.length){
            if(remaining == 0){
                result.add(new ArrayList<>(chosen));
            }
            return;
        }
        if(candidates[index] <= remaining){
            chosen.add(candidates[index]);
            solve(index, remaining- candidates[index], chosen, candidates);

            chosen.remove(chosen.size() - 1);
        }
        
        solve(index + 1, remaining, chosen, candidates);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(0, target, new ArrayList<>(), candidates);
        return result;
    }
}
