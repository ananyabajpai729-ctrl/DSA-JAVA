class Solution {
    public String reverseWords(String s) {
        s= s.trim();
        StringBuilder res = new StringBuilder();
        int ptr = s.length() - 1;

        while(ptr >= 0){
            while(ptr >= 0 && s.charAt(ptr) == 32){
                ptr--;
            }

            if(ptr < 0) break;

            int end = ptr;

            while(ptr >= 0 && s.charAt(ptr) != 32){
                ptr--;
            }

            String word = s.substring(ptr+1, end + 1);
            if(res.length() > 0){
                res.append(" ");
            }
            res.append(word);
        }

        return res.toString();
    }
}
