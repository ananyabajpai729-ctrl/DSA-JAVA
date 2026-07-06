class MinStack {
    private Stack<Long> stk;
    private long mini;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        long value = (long)val;
        if(stk.isEmpty()){
            stk.push(value);
            mini = value;
            return;
        }

        if(value > mini){
            stk.push(value);
        }else{
            stk.push(2* value - mini);
            mini = value;
        }
    }
    
    public void pop() {
        if(stk.isEmpty()) return;

        long ele = stk.pop();

        if(ele < mini){
            mini = (2 * mini - ele);
        }

    }
    
    public int top() {
        if(stk.isEmpty()) return -1;

        long x = stk.peek();

        if(x < mini) return (int)mini;

        return (int)x;
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
