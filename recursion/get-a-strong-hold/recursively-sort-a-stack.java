import java.util.*;
class Solution {
    private void insert(Stack<Integer> st, int ele){
        if(st.isEmpty() || st.peek()<= ele){
            st.push(ele);
            return;
        }

        int val = st.pop();
        insert(st, ele);
        st.push(val);
    }
    private void helper(Stack<Integer> st){
        if(!st.isEmpty()){
            int temp = st.pop();
            helper(st);
            insert(st, temp);
        }
    }
    public void sortStack(Stack<Integer> st) {
        helper(st);
    }
}
