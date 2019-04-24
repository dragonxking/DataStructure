package linkedlist.demo;

import linkedlist.base.ISingleLinkedList;
import linkedlist.base.Node;

public class DemoSingleLinkedList implements ISingleLinkedList {

    public Node mHead = null;

    public void insertAll(int[] data) {
        if (data != null && data.length > 0) {
            for (int i = 0; i < data.length; i++) {
                insertTail(data[i]);
            }
        }
    }


    @Override
    public Node findByValue(int value) {
        Node p = mHead;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    @Override
    public Node findByIndex(int index) {
        int pos = 0;
        Node p = mHead;
        while (p.next != null && pos!=index) {
            p = p.next;
            pos++;
        }
        return p;
    }

    @Override
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        if (this.mHead == null) {
            this.mHead = newNode;
        } else {
            newNode.next = mHead;
            mHead = newNode;
        }
    }

    @Override
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (this.mHead == null) {
            this.mHead = newNode;
        } else {
            Node p = mHead;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }

    @Override
    public void insertAfter(Node p, int value) {
        if (p != null) {
            Node newNode = new Node(value, null);
            insertAfter(p, newNode);
        }
    }

    @Override
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    @Override
    public void insertBefore(Node p, int value) {
        if (p != null) {
            Node newNode = new Node(value, null);
            insertBefore(p, newNode);
        }
    }

    @Override
    public void insertBefore(Node base, Node newNode) {
        if (this.mHead == null) {
            return;
        } else {
            Node p = mHead;
            if (mHead == base) {
                newNode.next = base;
                this.mHead = newNode;
            } else {
                while (p.next != null) {
                    if (p.next != base) {
                        p = p.next;
                    } else {
                        break;
                    }
                }
                newNode.next = base;
                p.next = newNode;
            }
        }
    }

    @Override
    public void deleteByNode(Node p) {
        if (mHead == null || p == null) {
            return;
        }

        if (mHead == p) {
            this.mHead = this.mHead.next;
            return;
        }

        Node q = mHead;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) return;
        q.next = q.next.next;

    }

    @Override
    public void deleteByValue(int value) {
        if (mHead != null) {
            Node p = mHead;
            Node q = null;
            while (p != null && p.data != value) {
                q = p;
                p = p.next;
            }
            if (p == null) return;
            if (q == null) {
                this.mHead = this.mHead.next;
            } else {
                q.next = p.next;
            }
        }
    }

    @Override
    public void printAll() {
        if (this.mHead == null) {
            return;
        } else {
            Node p = mHead;
            while (p != null) {
                System.out.println(p);
                p = p.next;
            }
        }
    }

    @Override
    public boolean palindrome() {
        return false;
    }

    @Override
    public Node inverseLinkList_head(Node p) {
        return null;
    }

    @Override
    public Node inverseLinkList(Node p) {
        return null;
    }


    public static void main(String[] args) {
        System.out.println("Test");
        System.out.println("=========================================test data");
        DemoSingleLinkedList test = new DemoSingleLinkedList();
        test.insertAll(new int[]{10, 20, 30, 40, 50, 60});
        test.printAll();
        System.out.println("=========================================findByValue(30)");
        Node node_30 = test.findByValue(30);
        System.out.println("found: " + node_30);
        System.out.println("=========================================findByValue(100)");
        Node founded = test.findByValue(100);
        System.out.println("found: " + founded);
        System.out.println("=========================================findByIndex(99)");
        Node founded2 = test.findByIndex(99);
        System.out.println("found: " + founded2);
        System.out.println("=========================================insertToHead(0)");
        test.insertToHead(0);
        test.printAll();
        System.out.println("=========================================insertAfter 35 after 30 ");
        test.insertAfter(node_30, 35);
        test.printAll();
        System.out.println("=========================================insertBefore 25 before 30");
        test.insertBefore(node_30, 25);
        test.printAll();
        System.out.println("=========================================findByValue(0) ");
        Node node_0 = test.findByValue(0);
        System.out.println("found: " + node_0);
        System.out.println("=========================================insertBefore -40 before 0 ");
        test.insertBefore(node_0, -40);
        test.printAll();
        System.out.println("=========================================insertBefore -10 before 0 ");
        test.insertBefore(node_0, -10);
        test.printAll();
        System.out.println("=========================================deleteByValue 35 ");
        test.deleteByValue(35);
        test.printAll();
        System.out.println("=========================================deleteByNode node_0 ");
        test.deleteByNode(node_0);
        test.printAll();

    }
}
