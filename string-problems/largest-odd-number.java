class Solution {
    public String largestOddNumber(String num) {
        
        for (int i = num.length() - 1; i >= 0; i--) {
            
            int digit = num.charAt(i) - '0'; 
            
            // returning the answer string as soon as we encounter an odd digit from the end
            if (digit % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found, return an empty string
        return "";
    }
}
