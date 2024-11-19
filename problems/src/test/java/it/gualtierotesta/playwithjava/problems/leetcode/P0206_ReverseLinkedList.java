package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0206_ReverseLinkedList {

    private static class ListNode {
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

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode newList = null;
        while (current != null) {
            if (newList == null) {
                newList = new ListNode(current.val);
            } else {
                newList = new ListNode(current.val, newList);
            }
            current = current.next;
        }
        return newList;
    }

}
