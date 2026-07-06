class Solution {
    public String prefixToPostfix(String s) {
        Stack<String> stk = new Stack<>();
        int n = s.length();

        for(int i = n - 1; i>=0; i--){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)){
                stk.push(String.valueOf(c));
            }else{
                String op1 = stk.pop();
                String op2 = stk.pop();

                stk.push(  op1 + op2 + c );
            }
        }

        return stk.peek();
    }
}
