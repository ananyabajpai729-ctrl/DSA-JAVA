/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode fst= headA;
        ListNode sec = headB;

        while(fst!= sec){
            fst =fst== null? headB: fst.next;
            sec = sec== null? headA: sec.next;
        }
        return fst;
    }
}
