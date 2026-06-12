class Solution {
    public String frequencySort(String s) {
        int [][] freq = new int[128][2];
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i< s.length() ; i++){
            char ch = s.charAt(i);
            
            freq[ch][0] = ch;       // Store the actual character ASCII value directly
            freq[ch][1]++;          // Increment count
        }
        Arrays.sort(freq, (row1, row2) -> Integer.compare(row2[1], row1[1]));
        for(int i = 0; i<freq.length; i++){
            if(freq[i][1] == 0) break;
            char letter = (char) freq[i][0];
            for(int j = 0; j < freq[i][1]; j++){
                res.append(letter);
            }
        }

        return res.toString();
    }
}
