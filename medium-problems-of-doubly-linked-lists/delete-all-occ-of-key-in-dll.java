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
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode dummy = new ListNode(-1, head, null);
        ListNode currNode = head;
        if(head!= null) head.prev = dummy;

        while(currNode != null){
            if(currNode.val == target){
                ListNode temp = currNode.next;
                ListNode prevNode = currNode.prev;
                
                
                prevNode.next = temp;
                
                
                if (temp != null) {
                    temp.prev = prevNode;
                }
                
               
                currNode.next = null;
                currNode.prev = null; 
                
                currNode = temp;
            }else{
                currNode = currNode.next;
            }
        }

        if(dummy.next != null){
            dummy.next.prev= null;
        }
        return dummy.next;
    }
}
