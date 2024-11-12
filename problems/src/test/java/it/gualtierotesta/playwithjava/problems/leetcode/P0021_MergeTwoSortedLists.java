package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0021_MergeTwoSortedLists {


    static class ListNode {
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

    private static ListNode add(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;

        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return head;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode n1 = list1;
        ListNode n2 = list2;
        ListNode result = null;
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                result = add(result, n2.val);
                n2 = n2.next;
            } else if (n2 == null) {
                result = add(result, n1.val);
                n1 = n1.next;
            } else if (n1.val < n2.val) {
                result = add(result, n1.val);
                n1 = n1.next;
            } else {
                result = add(result, n2.val);
                n2 = n2.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode result = mergeTwoLists(l1, l2);


        System.out.println("result.val = " + result.val);
    }

}
