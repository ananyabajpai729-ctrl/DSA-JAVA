class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i  = 0; i< s.length();){
            if(i != s.length() -1 && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))){
                ans = ans + getValue(s.charAt(i + 1)) - getValue(s.charAt(i));
                i+=2;
            }else{
                ans = ans + getValue(s.charAt(i));
                i++;
            }
        }

        return ans;
    }

    private int getValue(char c) {
        return switch (c) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> 0;
        };
    }
}
