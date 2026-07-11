class Solution {
    private int[] nse(int[] nums){
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for(int i = n-1; i>= 0 ; i-- ){
            int ele = nums[i];

            while(!stk.isEmpty() && ele <= nums[stk.peek()]){
                stk.pop();
            }

            ans[i] = stk.isEmpty() ? n : stk.peek();

            stk.push(i);
        }
        return ans;
    }
    private int[] nge(int[] nums){
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for(int i = n-1; i>= 0 ; i-- ){
            int ele = nums[i];

            while(!stk.isEmpty() && ele >= nums[stk.peek()]){
                stk.pop();
            }

            ans[i] = stk.isEmpty() ? n : stk.peek();

            stk.push(i);
        }
        return ans;
    }
    private int[] psee(int[] nums){
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0 ; i< n; i++){
            int ele = nums[i];
            while(!stk.isEmpty() && ele < nums[stk.peek()]){
                stk.pop();
            }

            ans[i] = stk.isEmpty() ? -1: stk.peek();

            stk.push(i);
        }
        return ans;
    }
    private int[] pgee(int[] nums){
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0 ; i< n; i++){
            int ele = nums[i];
            while(!stk.isEmpty() && ele > nums[stk.peek()]){
                stk.pop();
            }

            ans[i] = stk.isEmpty() ? -1: stk.peek();

            stk.push(i);
        }
        return ans;
    }
    private long sumSubarrayMaxs(int[] nums){
        int n = nums.length;
        int[] nge = nge(nums);
        int[] pgee = pgee(nums);
        long sum = 0;

        for(int i = 0; i < n; i++){
            int left = i - pgee[i];
            int right = nge[i] - i;
            long freq = 1l * left * right ;
            sum += freq* nums[i];
        }
        return sum;
    }
    private long sumSubarrayMins(int[] nums){
        int n = nums.length;
        int[] nse = nse(nums);
        int[] psee = psee(nums);
        long sum = 0;

        for(int i = 0; i < n; i++){
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = 1l * left * right ;
            sum += freq* nums[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }
}
