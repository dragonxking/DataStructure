package mydemo.linkedlist;

public interface ISingleLinkedList {
    Node findByValue(int value);

    Node findByIndex(int index);

    void insertToHead(int value);

    void insertTail(int value);

    void insertAfter(Node p, int value);

    void insertAfter(Node p, Node newNode);

    void insertBefore(Node p, int value);

    void insertBefore(Node p, Node newNode);

    void deleteByNode(Node p);

    void deleteByValue(int value);

    void printAll();

    /**
     * 带结点的链表翻转
     */
    Node inverseLinkList_head(Node p);

    /**
     * 无头结点的链表翻转
     */
    Node inverseLinkList(Node p);

    class Node {
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

}
