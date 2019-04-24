package linkedlist.base;

public class Node {
    public int data;
    public Node next;
    public char c;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Node next, char c) {
        this.next = next;
        this.c = c;
    }

    public Node(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                "," + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) +
                '}';
    }
}
