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
    public ListNode findMiddle(ListNode head){
        ListNode turtle = head;
        ListNode hare = head;
        while(hare.next != null && hare.next.next!= null){
            turtle = turtle.next;
            hare= hare.next.next;
        }
        return turtle;
    }
    public ListNode reverse(ListNode head1){
        ListNode currNode = head1;
        ListNode prevNode = null;
        while(currNode != null){
            ListNode temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }
        return prevNode;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddle(head);

        ListNode fst = head;
        ListNode sec = reverse(mid.next);

        while(sec != null){
            if(fst.val != sec.val) return false;
            fst = fst.next;
            sec = sec.next;
        }
        return true;
    }
}
