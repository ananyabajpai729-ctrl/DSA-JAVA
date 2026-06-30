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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fst = head;
        ListNode sec = head.next;
        ListNode head1 = head;
        ListNode head2 = head.next;
        while(fst != null && sec != null && sec.next != null){
            fst.next = fst.next.next;
            sec.next = sec.next.next;
            fst = fst.next;
            sec = sec.next;
        }
        fst.next = head2;

        return head1;
    }
}
