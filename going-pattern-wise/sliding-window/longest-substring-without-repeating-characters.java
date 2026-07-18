class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256]; // to store last occurrence of every element which we encounter
        int left = 0;
        int maxLen = 0;
        Arrays.fill(hash, -1);

        for(int right = 0; right < s.length(); right++){
            //Now we check if this element at right index has its last occurrence inside the window i.e. after left index
            if(hash[s.charAt(right)] >= left){ 
                left = Math.max(left, hash[s.charAt(right)] + 1);
            }

            maxLen = Math.max(maxLen, right - left + 1);
            hash[s.charAt(right)] = right;
        }
        return maxLen;
    }
}
