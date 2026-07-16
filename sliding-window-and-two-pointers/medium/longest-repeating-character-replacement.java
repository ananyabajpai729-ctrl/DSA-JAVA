class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int[] hash = new int[26];
        int maxFreq = 0;

        for(int left = 0, right = 0; right < s.length(); right++){
            hash[s.charAt(right) - 'A']++;

            //finding maxFreq to determine how many elements are not max, so they have to be replaced in order to be placed in this window
            maxFreq = Math.max( maxFreq, hash[s.charAt(right) - 'A']);

            //if no.of replacements are more than k, then we start shrinking the window
            while((right - left + 1) - maxFreq > k){
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
