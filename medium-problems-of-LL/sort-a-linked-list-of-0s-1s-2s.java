/*
Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/

class Solution {
    public ListNode sortList(ListNode head) {
        //YOUR CODE GOES HERE
        ListNode zeroListHead = new ListNode(-1);
        ListNode oneListHead = new ListNode(-1);
        ListNode twoListHead = new ListNode(-1);
        ListNode temp0 = zeroListHead;
        ListNode temp1 = oneListHead;
        ListNode temp2 = twoListHead;
        ListNode temp = head;
        while(temp != null){
            if(temp.data == 0){
                temp0.next = temp;
                temp0= temp0.next;
            }else if(temp.data == 1){
                temp1.next = temp;
                temp1 = temp1.next;
            }else{
                temp2.next = temp;
                temp2= temp2.next;
            }
            temp = temp.next;
        }
        temp0.next = (zeroListHead.next != null)? oneListHead.next: twoListHead.next;
        temp1.next = twoListHead.next;
        temp2.next = null;

        return zeroListHead.next;
    }
}
