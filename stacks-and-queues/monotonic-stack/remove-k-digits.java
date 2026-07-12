class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i< n; i++){
            char digit = num.charAt(i);

            while(!stk.isEmpty() && stk.peek() > digit && k >0){
                stk.pop();
                k--;
            }

            stk.push(digit);
        }

        while(k > 0){
            stk.pop();
            k--;
        }

        if(stk.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();

        while(!stk.isEmpty()){
            res.append(stk.pop());
        }
        //if(res.length() == 1 && res.charAt(0) == '0') return res.toString();
        while(res.length() > 0 && res.charAt(res.length() - 1) == '0'){
            if(res.length() == 1 && res.charAt(0) == '0') return res.toString();
            res.deleteCharAt(res.length() - 1);
        }

        res.reverse();

        return res.toString();
    }
}
