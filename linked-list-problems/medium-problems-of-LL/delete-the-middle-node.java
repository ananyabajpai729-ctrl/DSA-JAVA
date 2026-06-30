/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode dummy = new ListNode(0, head);
        ListNode turtle = dummy;
        ListNode hare = dummy;

        while(hare.next != null && hare.next.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }

        turtle.next = turtle.next.next;
        return dummy.next;
    }
}
