package netanswer;

import mydemo.linkedlist.Node;

/**
 * 我眼中的民间高手
 */
public class LinkedList {
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node cur = head;
        Node next = head.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = prev;
        return cur;
    }


    public static boolean existsCircle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static Node merge(Node head1, Node head2) {

        Node guard = new Node('/');
        Node cur = guard;

        while (head1 != null && head2 != null) {
            if (head1.c <= head2.c) {
                while (head1 != null && head1.c <= head2.c) {
                    cur.next = head1;
                    cur = cur.next;
                    head1 = head1.next;

                }
            } else {
                while (head2 != null && head1.c > head2.c) {
                    cur.next = head2;
                    cur = cur.next;
                    head2 = head2.next;

                }
            }
        }

        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }

        return guard.next;

    }

    public static Node deleteLastN(Node head, int n) {
        if (n < 1 || head == null) {
            return head;
        }
        Node guard = new Node('/');
        guard.next = head;

        Node slow = guard;
        Node fast = guard;

        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return guard.next;
    }

    public static Node getMiddle(Node head, int n) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
