class Solution {
    public int myAtoi(String s) {
        // 1. Handle empty string
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // 2. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If the string was only spaces
        if (i == n) {
            return 0;
        }

        // 3. Check for sign
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        // 4. Convert digits and handle overflow
        int ans = 0;
        while (i < n) {
            char ch = s.charAt(i);
            
            // If it's not a valid digit, break immediately
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // Check for overflow before multiplying
            // Integer.MAX_VALUE is 2147483647. 
            // If ans > 214748364, multiplying by 10 will definitely overflow.
            // If ans == 214748364, adding any digit greater than 7 will overflow.
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }
}
