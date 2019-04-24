package linkedlist.base;

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
     * 判断是否为回文
     */
    boolean palindrome();

    /**
     * 带结点的链表翻转
     */
    Node inverseLinkList_head(Node p);

    /**
     * 无头结点的链表翻转
     */
    Node inverseLinkList(Node p);

}
