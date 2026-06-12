class Solution {
    public int maxDepth(String s) {
        int ptr = 0;
        int maxDepth = Integer.MIN_VALUE;
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                ptr++;
            }else if(s.charAt(i) == ')'){
                ptr--;
            }
            maxDepth = Math.max(maxDepth, ptr);
        }
        return maxDepth;
    }
}
