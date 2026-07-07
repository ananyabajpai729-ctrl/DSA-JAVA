class Solution {
    public String postToInfix(String postExp) {
        Stack<String> stk = new Stack<>();
        int n = postExp.length();

        for(int i = 0; i< n; i++){
            char c = postExp.charAt(i);

            if(Character.isLetterOrDigit(c)){
                stk.push(String.valueOf(c));
            }else{
                String op1 = stk.pop();
                String op2 = stk.pop();

                stk.push("(" + op2 + c + op1 + ")");
            }
        }

        return stk.peek();
    }
}
