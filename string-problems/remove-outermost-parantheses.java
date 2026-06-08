class Solution {
    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                level++;
                if(level > 1){
                    res.append('(');
                }
            }else if(c == ')'){
                level--;
                if(level > 0 ){
                    res.append(')');
                }
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
