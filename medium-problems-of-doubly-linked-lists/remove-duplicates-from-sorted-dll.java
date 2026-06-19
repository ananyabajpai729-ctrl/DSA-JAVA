/*Definition of doubly linked list:
class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}
 */

class Solution {
    public ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode currNode = head;

        while(currNode != null && currNode.next != null){
            ListNode nextNode = currNode.next;

            while(nextNode != null && currNode.val == nextNode.val){
                nextNode = nextNode.next;
            }

            currNode.next = nextNode;

            if(nextNode != null){
                nextNode.prev = currNode;
            }
            currNode = nextNode;
        }

        return head;
    }
}
