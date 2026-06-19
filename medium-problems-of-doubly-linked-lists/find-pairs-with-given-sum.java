/*
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (head == null) return ans;

        ListNode left = head;
        ListNode right = head;

        
        while (right.next != null) {
            right = right.next;
        }

        
        while (left != right && right.next != left) {
            int currentSum = left.val + right.val;

            if (currentSum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(left.val);
                pair.add(right.val);
                ans.add(pair);

                
                left = left.next;
                right = right.prev; 
            } 
            else if (currentSum < target) {
                
                left = left.next;
            } 
            else {
                
                right = right.prev;
            }
        }

        return ans;
    }
}
