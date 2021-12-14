package LinkedList.P206;

import java.util.LinkedList;

public class ListNode {

    int data;

    ListNode next;

    ListNode(int data) {
        this.data = data;
    }

    ListNode(int data, ListNode nextNode) {
        this.data = data;
        this.next = nextNode;
    }

    public int getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
