package practice;

import java.util.HashSet;
import java.util.Set;

public class LinkedListDisjointSet {

    public Node makeSet(int val) {
        Node dummyHead = new Node(1); //length of 1
        Node node = new Node(val);
        dummyHead.next = node;
        dummyHead.head = node;
        node.head = dummyHead;
        node.next = null;
        return node;
    }

    public Node union(Node x, Node y) {
        Node headx = find(x);
        Node heady = find(y);
        if (headx == heady) {
            return headx; //x and y are in the same set, return their head
        }
        //weighted-union heuristic
        if (heady.val > headx.val) { //heady's length is larger that headx, swap them
            Node tmp = headx;
            headx = heady;
            heady = tmp;
        }
        //now headx.length >= heady.length;
        headx.head.next = heady.next;
        headx.head = heady.head;
        headx.val += heady.val;
        Node curr = heady.next;
        while(curr != null) {
            curr.head = headx;
            curr = curr.next;
        }
        return headx;
    }

    public Node find(Node x) {
        return x.head;
    }

    public Set<Integer> getSet(Node x) {
        Set<Integer> set = new HashSet<>();
        Node curr = x.head.next;
        while(curr != null) {
            set.add(curr.val);
            curr = curr.next;
        }
        return set;
    }

}


class Node {
    int val; //dummyhead's val is the length of the set
    Node head; //dummyhead's head will point to tail
    Node next;
    Node(int val) {
        this.val = val;
    }
}