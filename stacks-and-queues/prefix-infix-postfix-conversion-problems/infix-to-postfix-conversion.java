import java.util.*;
class Solution {
    private int prec(char c){
        if(c == '^') return 3;
        if(c == '/' || c=='*') return 2;
        if(c== '+' || c=='-') return 1;
        return -1;
    }
    public String infixToPostfix(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)){
                res.append(c);
            }

            else if(c == '('){
                stk.push('(');
            }

            else if(c == ')'){
                while(stk.peek() != '('){
                    res.append(stk.pop());
                }
                stk.pop();
            }

            else{
                while(!stk.isEmpty()&&(prec(c)<prec(stk.peek())||(prec(c)==prec(stk.peek())&&c!= '^'))){
                    res.append(stk.pop());
                }
                stk.push(c);
            }

        }

        while(!stk.isEmpty()){
            res.append(stk.pop());
        }

        return res.toString();
    }
}
