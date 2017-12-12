package leetcode;

public class ReverseListKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //check head == null, return 0
    //check k == 0, k == 1 return unchanged lists
    //if k < 0, illegal argument
    //time: O(n)
    //space: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k < 0) {
            throw new IllegalArgumentException();
        }
        if (k <= 1) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        while(hasNext(prev, k)) {
            prev = reverse(prev, k);
        }
        return sentinel.next;
    }

    boolean hasNext(ListNode prev, int k) {
        ListNode curr = prev;
        for (int i = 1; i <= k; ++i) {
            if (curr.next == null) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
    //assume the next k nodes exists
    ListNode reverse(ListNode prev, int k) {
        ListNode last = prev.next;
        for (int i = 1; i< k; ++i) { //loop for k-1 times
            ListNode tmp = prev.next;
            prev.next = last.next;
            last.next = last.next.next;
            prev.next.next = tmp;
        }
        return last;
    }
}
