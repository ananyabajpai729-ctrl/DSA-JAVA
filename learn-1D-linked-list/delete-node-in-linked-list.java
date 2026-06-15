/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        ListNode newNextNode = node.next.next;
        node.val = nextNode.val;
        node.next = newNextNode;
        nextNode.next = null;
    }
}
