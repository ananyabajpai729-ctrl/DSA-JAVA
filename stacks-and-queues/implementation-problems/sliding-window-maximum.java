class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i< nums.length ; i++){
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k - 1){
                ans.add(dq.peekFirst());
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i< ans.size(); i++){
            res[i] = nums[ans.get(i)];
        }

        return res;
    }
}
