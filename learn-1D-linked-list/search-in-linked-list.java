/* Defination of ListNoode
class ListNode {
    int val;
    ListNode next;

    ListNode(int value) {
        this.val = value;
        this.next = null;
    }
}
*/


class Solution {
    public boolean searchKey(ListNode head, int key) {
        // Your code goes here
        ListNode currNode = head;

        while(currNode != null){
            if(currNode.val == key)return true;
            currNode = currNode.next;
        }
        return false;
    }
}
