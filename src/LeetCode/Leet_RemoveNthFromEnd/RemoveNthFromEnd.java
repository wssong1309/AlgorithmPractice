package LeetCode.Leet_RemoveNthFromEnd;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prevNode = head;
        ListNode lastNode = head;

        for (int i = 0; i < n; i++) {
            lastNode = lastNode.next;
        }

        if (lastNode == null) {
            return head.next;
        }

        while (lastNode.next != null) {
            prevNode = prevNode.next;
            lastNode = lastNode.next;
        }

        ListNode deleteNode = prevNode.next;
        prevNode.next = deleteNode.next;

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}