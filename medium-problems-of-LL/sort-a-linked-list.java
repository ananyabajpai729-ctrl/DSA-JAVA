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
    private ListNode merging(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1, null);
        ListNode temp = dummy;

        while(head1!= null && head2!= null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1!= null){
            temp.next = head1;
            head1 = head1.next;
            temp= temp.next;
        }

        if(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp= temp.next;
        }

        return dummy.next;
    }
    private ListNode findMiddle(ListNode head){
        ListNode turtle = head;
        ListNode hare = head;

        while(hare.next != null && hare.next.next!= null){
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return turtle;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return merging(left, right);
    }
}
