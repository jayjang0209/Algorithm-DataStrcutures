package LinkedList.P206;

/**
 * LeetCode P206. Reverse Linked List.
 *
 * @author Jonghoon Jang
 * @version Dec, 2021
 */
public class ReverseLinkedList {

    /**
     * Given the head of a singly linked list, reverse the list,
     * and return the reversed list.
     *
     * @param head a head of singly linked list
     * @return newHead a head of reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
