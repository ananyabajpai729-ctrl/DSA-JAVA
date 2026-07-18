class Solution {
    public int operation(int num){
        int ans = 0;
        while(num > 0){
            int digit = num %10;
            ans += digit* digit;
            num/= 10;
        }

        return ans;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = operation(slow);
            fast = operation(operation(fast));
        }while(slow != fast);

        return slow ==1;
    }
}
