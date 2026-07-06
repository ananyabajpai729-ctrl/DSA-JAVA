class Node{
    int val;
    Node next;
    Node(int x){
        val = x;
        next = null;
    }
}
class LinkedListStack {
    private Node head;
    private int size;

    public LinkedListStack() {
        head = null;
        size = 0;
    }

    public void push(int x) {
       Node ele = new Node(x);
       
       ele.next = head;
       head = ele;
       size++;
    }

    public int pop() {
        if(head == null) return -1;
        int value = head.val;
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;

        return value;
    }

    public int top() {
        if(head == null) return -1;
        return head.val;
    }

    public boolean isEmpty() {
        return size==0;
    }
}
