class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int res = 0;
        int[] map = new int[3];

        for(int right = 0; right < s.length(); right++){
            map[s.charAt(right) - 'a']++;

            while(map[0] > 0 && map[1] > 0 && map[2] >0){
                res += s.length() - right;

                map[s.charAt(left) - 'a']--;
                left++;
            }
        }


        return res;
    }
}
