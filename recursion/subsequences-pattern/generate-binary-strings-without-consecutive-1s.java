import java.util.*;
class Solution {
    List<String> ans = new ArrayList<>();
    public void helper(int index, int n, String res){
        if(index == n){
            ans.add(res);
            return;
        }
        helper(index + 1, n, res + '0');

        if(res.isEmpty() || res.charAt(res.length() - 1) == '0'){
            helper(index + 1, n, res + '1');
        }
    }
    public List<String> generateBinaryStrings(int n) {
        // Your code goes here
        ans = new ArrayList<>();
        helper(0,n, "");
        return ans;
    }
}
