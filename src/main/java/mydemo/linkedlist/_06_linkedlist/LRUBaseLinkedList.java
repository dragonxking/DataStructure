package mydemo.linkedlist._06_linkedlist;

import mydemo.linkedlist._07_linkedlist.ISingleLinkedList;

import java.util.Scanner;

/**
 * 最近使用的元素作为头结点；
 * 从链表尾部删除元素
 *
 * @param <T>
 */
public class LRUBaseLinkedList<T> {

    //默认头结点
    public FNode head;
    //额定容量
    public int capacity = 4;
    //已用容量
    public int count = 0;

    public LRUBaseLinkedList() {
        this.head = new FNode();
        this.count = 0;
    }

    public LRUBaseLinkedList(int capacity) {
        this.head = new FNode();
        this.capacity = capacity;
        this.count = 0;
    }

    public void add(T data) {
        FNode preNode = findPreNodeByValue(data);
        if (preNode != null) {
            deleteElemOptim(preNode);
            addNodeAtHead(data);
        } else {
            if (count >= capacity) {
                //删除为结点
                deleteNodeAtEnd();
            }
            addNodeAtHead(data);
        }
    }

    private void addNodeAtHead(T data) {
        FNode h = head.next;
        head.setNext(new FNode(data, h));
        count++;
    }

    private void deleteElemOptim(FNode preNode) {
        FNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        count--;
    }

    private FNode findPreNodeByValue(T data) {
        FNode node = head;
        while(node.getNext()!=null){
            if(data.equals(node.getNext().getData())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void deleteNodeAtEnd() {
        FNode p = head;
        if (p.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (p.getNext().getNext() != null) {
            p = p.next;
        }
        p.setNext(null);
        count--;
    }


    class FNode<T> {
        private FNode next;
        private T data;

        public FNode(T data, FNode next) {
            this.next = next;
            this.data = data;
        }

        public FNode() {
            this.next = null;
        }

        public FNode(T data) {
            this.data = data;
        }

        public FNode getNext() {
            return next;
        }

        public void setNext(FNode next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public void printAll() {
        if (this.head == null) {
            System.out.println("null");
            return;
        }
        FNode p = this.head.getNext() ;
        while (p != null) {
            System.out.print(p.getData() + ",");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}
