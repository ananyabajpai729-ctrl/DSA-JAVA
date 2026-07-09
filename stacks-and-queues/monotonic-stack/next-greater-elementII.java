class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = 2*n - 1; i>=0; i--){
            int index = i %n;

            while(!stk.isEmpty() && stk.peek() <= nums[index]){
                stk.pop();
            }
            if(i < n){
                if(stk.isEmpty()) res[index] = -1;
                else res[index] = stk.peek();
            }
                

            stk.push(nums[index]);
        }

        return res;
    }
}
