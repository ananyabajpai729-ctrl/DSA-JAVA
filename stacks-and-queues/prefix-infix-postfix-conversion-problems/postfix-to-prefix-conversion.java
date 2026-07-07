class Solution {
    public String postToPre(String postfix) {
        Stack<String> stk = new Stack<>();
        int n = postfix.length();

        for(int i = 0; i < n ; i++){
            char c= postfix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stk.push(String.valueOf(c));
            }else{
                String op1 = stk.pop();
                String op2 = stk.pop();

                stk.push(c + op2 + op1);
            }
        }

        return stk.peek();
    }
}
