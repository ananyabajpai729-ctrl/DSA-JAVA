class Solution {
    public int[] nextLargerElement(int[] arr) {
        int[] nge = new int[arr.length];
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();

        for(int i = n - 1; i >=0; i--){
            int ele = arr[i];
            
            while(!stk.isEmpty() && stk.peek() <= ele){
                stk.pop();
            }

            if(stk.isEmpty()) nge[i] = -1;
            else nge[i] = stk.peek();

            stk.push(ele);
        }

        return nge;
    }
}
