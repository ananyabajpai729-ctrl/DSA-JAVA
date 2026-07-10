class Solution {
    private int[] nse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();

        for(int i = n-1; i>=0; i--){
            int ele = arr[i];
            while(!stk.isEmpty() && ele <= arr[stk.peek()]){
                stk.pop();
            }

            if(stk.isEmpty()) ans[i] = n;
            else ans[i] = stk.peek();

            stk.push(i);
        }

        return ans;
    }
    private int[] psee(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            int ele = arr[i];
            while(!stk.isEmpty() && ele < arr[stk.peek()]){
                stk.pop();
            }

            if(stk.isEmpty()) ans[i] = -1;
            else ans[i] = stk.peek();

            stk.push(i);
        }

        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] nse = nse(arr);
        int[] psee = psee(arr);

        int MOD = (int)1e9 + 7;
        long sum = 0;

        for(int i = 0; i< arr.length; i++){
            long left = i - psee[i];
            long right =  nse[i] - i;

            long freq = left * right * 1l;

            int val = (int)(freq * arr[i] % MOD);

            sum = (sum + val) %MOD;
        }

        return (int)sum;
    }
}
