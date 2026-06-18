/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode reverse(ListNode head){
        ListNode prevNode = null;
        ListNode currNode = head;
        while(currNode!= null){
            ListNode temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }
        return prevNode;
    }
    public ListNode addOne(ListNode head) {
        ListNode newHead = reverse(head);
        int flag = -1;
        ListNode track = newHead;
        while(track != null){
            int sum = track.val + 1;
            if(sum == 10){
                flag=1;
                track.val = 0;
                track = track.next;
            }else{
                track.val = sum;
                flag = -1;
                break;
            }
        }
        ListNode finalHead = reverse(newHead);
        if(flag == 1){
            ListNode appendage = new ListNode(1, finalHead);
            return appendage;
        }
        return finalHead;
    }
}
