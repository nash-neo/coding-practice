package language;

import org.junit.Test;

public class LinkedListTest {

    private static class Node {
        int val;
        Node next;
        public Node(int val) {this.val = val;}
    }

    //recursively reverse
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        else {
            Node newTail = head.next;
            Node newHead = reverse(head.next);
            newTail.next = head;
            head.next = null;
            return newHead;
        }
    }

    //recursion 2, call reverse(head, null)
    public Node reverse(Node curr, Node prev) {
        if (curr == null) {
            return prev;
        }
        else {
            Node next = curr.next;
            curr.next = prev;
            return reverse(next, curr);
        }
    }

    @Test
    public void testReverse() {
        Node n4 = new Node(4);
        Node n3 = new Node(3); n3.next = n4;
        Node n2 = new Node(2); n2.next = n3;
        Node n1 = new Node(1); n1.next = n2;
        print(n1);
        Node reversed = reverse(n1);
        print(reversed);
        Node original = reverseIterative(reversed);
        print(original);
        reversed = reverse(n1, null);
        print(reversed);
        original = reverseIterative2(reversed);
        print(original);
    }

    public Node reverseIterative(Node head) {
        if (head == null) {
            return head;
        }
        Node a = head;
        Node b = head.next;
        head.next = null;
        while (b != null) {
            Node c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }

    public Node reverseIterative2(Node head) {
        if(head == null) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void print(Node head) {
        System.out.print(head.val);
        if (head.next != null) {
            System.out.print("->");
            print(head.next);
        }
        else {
            System.out.println();
        }
    }
}
