class Solution {
    public int kDistinctChar(String s, int k) {
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if(map.size() > k){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
