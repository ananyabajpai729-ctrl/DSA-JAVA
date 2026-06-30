class Solution {
    private void dfs(String num, int target, int start, long curr_res, long lastOperand, String expr, List<String> result){
        if(start == num.length()){
            if(curr_res == target){
                result.add(expr);
            }
            return;
        }

        for(int i = start; i < num.length(); i++){
            if(i > start && num.charAt(start) == '0') return;

            String curr_num  = num.substring(start, i + 1);
            long curr_num_val = Long.parseLong(curr_num);

            if(start == 0){
                dfs(num, target, i + 1, curr_num_val, curr_num_val, curr_num, result);
            }else{
                dfs(num, target, i + 1, curr_res + curr_num_val, curr_num_val, expr + "+" + curr_num, result);
                dfs(num, target, i + 1, curr_res - curr_num_val, -curr_num_val, expr + "-" + curr_num, result);
                dfs(num, target, i + 1, curr_res - lastOperand + lastOperand * curr_num_val, lastOperand * curr_num_val, expr + "*" + curr_num, result);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", ans);
        return ans;
    }
}
