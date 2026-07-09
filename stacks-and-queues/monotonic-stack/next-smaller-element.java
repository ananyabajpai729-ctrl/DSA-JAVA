class Solution {
    public int[] nextSmallerElements(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = n-1; i>= 0; i--){
            while(!stk.isEmpty() && stk.peek() >= arr[i]){
                stk.pop();
            }

            if(stk.isEmpty()) nse[i] = -1;
            else nse[i] = stk.peek();

            stk.push(arr[i]);
        }

        return nse;
    }
}
