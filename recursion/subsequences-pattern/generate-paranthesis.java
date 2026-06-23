class Solution {
    public static void helper(int n, int open, int close, String ans, List<String> result){
        if(ans.length()==2*n){
            result.add(ans);
            return;
        }
        if(open<n){
            helper(n, open+1, close, ans+"(", result);
        }
        if(close<open){
            helper(n, open, close+1, ans+")", result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        helper(n, 0,0,  "", result);
        return result;
    }
}
