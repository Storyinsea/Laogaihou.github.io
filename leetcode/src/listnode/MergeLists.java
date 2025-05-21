package listnode;

class ListNode {
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

public class MergeLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = list1;
        ListNode q = list2;
        ListNode curr = dummyHead;
        while (p != null && q != null) {
            if (p.val < q.val) {
                curr.next = p;
                p = p.next;
            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
        if (p != null) {
            curr.next = p;
        }
        if (q != null) {
            curr.next = q;
        }
        return dummyHead.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    // 反转链表
    public ListNode reverLists(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!= null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
