package linkedlist.demo;

import linkedlist.base.ISingleLinkedList;
import linkedlist.base.Node;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 */
public class DemoSingleLinkedList2 implements ISingleLinkedList {

    private Node mHead = null;

    public void insertAll(int[] nodeData) {
        for (int i = 0; i < nodeData.length; i++) {
            insertTail(nodeData[i]);
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
        Node p = mHead;
        int pos = 0;
        while (p != null && pos != index) {
            pos++;
            p = p.next;
        }
        return p;
    }

    @Override
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertNodeToHead(newNode);
    }

    public void insertNodeToHead(Node newNode) {
        if (mHead == null) {
            mHead = newNode;
        } else {
            newNode.next = mHead; //注意等号右边是 mHead 而不是 mHead.next
            mHead = newNode;
        }
    }

    @Override
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (mHead == null) {
            mHead = newNode;
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
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    @Override
    public void insertAfter(Node p, Node newNode) {
        if (newNode == null) {
            return;
        }
        //此处不需要其他判断
        newNode.next = p.next;
        p.next = newNode;
    }

    @Override
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    //TODO re-write several times
    @Override
    public void insertBefore(Node p, Node newNode) {
        if (newNode == null) return;
        if (mHead == p) {
            insertNodeToHead(newNode);
            return;
        }
        Node c = mHead;
        while (c != null && c.next != p) {
            c = c.next;
        }
        if (c == null) {
            return;
        } else {
            newNode.next = p;
            c.next = newNode;
        }
    }

    //TODO re-write several times
    @Override
    public void deleteByNode(Node p) {
        if (p == null || mHead == null) {
            return;
        }
        if (p == mHead) {
            mHead = mHead.next;
        }
        Node cursor = mHead;
        while (cursor != null && cursor.next != p) {
            cursor = cursor.next;
        }
        if (cursor == null) return;
        cursor.next = cursor.next.next;
    }

    @Override
    public void deleteByValue(int value) {
        Node c = mHead;
        Node p = null;
        while (c != null && c.data != value) {
            p = c;
            c = c.next;
        }
        if (c == null) return;
        if (p == null) {
            mHead = mHead.next;
        } else {
            p.next = p.next.next;
        }
    }

    @Override
    public void printAll() {
        if (mHead == null) {
            System.out.println(mHead);
            return;
        }
        Node p = mHead;
        while (p != null) {
            System.out.println(p);
            p = p.next;
        }
    }

    public void printAll(Node headNode) {
        if (headNode == null) {
            System.out.println("null");
            return;
        }
        Node p = headNode;
        while (p != null) {
            System.out.println(p);
            p = p.next;
        }
    }

    @Override
    public boolean palindrome() {

        //TODO
        return false;
    }

    //带结点的链表翻转
    @Override
    public Node inverseLinkList_head(Node p) {
        Node o = new Node(-9999, null);
        o.next = p;

        Node cur = p.next;
        p.next = null;
        Node first = null;

        while (cur != null) {
            first = cur;
            cur = cur.next;

            first.next = o.next;
            o.next = first;
        }

        return o; //带有新增的o
    }

    public Node inverseLinkList_head_Test(Node head) {
        Node cur = head.next;
        Node o = new Node(1999, null);
        o.next = head;
        head.next = null;

        Node p = null;
        while (cur != null) {
            p = cur;
            cur = cur.next;

            p.next = o.next;
            o.next = p;
        }
        return p;
    }

    public Node inverseLinkList_head_Test2(Node head) {
        Node o = new Node(888, null);
        o.next = head;
        Node next = head.next;
        head.next = null;
        Node p = null;

        while (next != null) {
            p = next;
            next = next.next;

            p.next = o.next;
            o.next = p;
        }
        return o;
    }

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

    //TODO re-write several times
    public static Node reverse_Test(Node head) {
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
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }

    public static Node reverse_Test2(Node head) {
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
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }

    /**
     * 判断单向链表中是否存在环
     * 如果有环 快慢指针一定相遇(慢指针每前进1步 快指针前进2步）
     * 结论证明：https://blog.csdn.net/sinat_35261315/article/details/79205157
     * @param head
     * @return null：没有环；非null：相遇点
     */
    public static Node isCircular(Node head){
        Node slow  = head;
        Node fast  = head;

        while(slow!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }

    public static boolean isCircularLinkedList(Node head){
        return isCircular(head) != null;
    }

    /**
     * 获取环的长度
     * @param head
     * @return
     */
    public static int getCircleLength(Node head){
        Node repeatNode = isCircular(head);
        if(repeatNode==null){
            return 0;
        }else{
            Node slow = repeatNode;
            int count = 0;
            while(slow.next!=repeatNode){
                slow=slow.next;
                count++;
            }
            return count+1;
        }
    }

    /**
     * 环的入口节点
     * 定理 ： 距离：【头～入口】=【相遇点～入口】
     * 定理证明： lenA = [头～入口]； 环长：R  ； [入口～相遇点] = x
     * 相遇时 ： fast速度是slow的两倍：fast走过距离 = 2 * slow走过距离 即：(n：第几次相遇)
     * lenA + x + nR = 2(lenA + x)
     * nR = lenA + x
     * lenA = nR - x
     * n=1时 即第一次进入环的入口： lenA = R - x
     * @param head
     * @return
     *
     */
    public static Node getJoinNode(Node head){
        Node meetPosition = isCircular(head);
        Node a = head;
        Node p = meetPosition;
        while(a!=p){
            a = a.next;
            p = p.next;
        }
        return a;
    }

    /**
     * 带有环的单向链表的全长
     * @param head
     * @return
     */
    public static int getTotalLength(Node head){
        int headToJoinLength = 0;
        Node joinNode = getJoinNode(head);
        Node p = head;
        while(p!=joinNode){
            p = p.next;
            headToJoinLength++;
        }
        return headToJoinLength + getCircleLength(head);
    }

    @Override
    public Node inverseLinkList(Node p) {
        return null;
    }

    //TODO

    /**
     * 合并两个LinkedList
     * @param headA
     * @param headB
     */
    public static void mergeTwoLinkedList(Node headA,Node headB){

    }

    //TODO
    /**
     * 删除倒数位置为pos的节点
     * @param head
     * @param pos
     */
    public static void deleteLastNodeX(Node head, int pos){

    }

    //TODO

    /**
     * 获取中间节点/
     * @param head
     */
    public static Node getMiddleNode(Node head){
        return null;
    }


    //TODO

    /**
     * 是否为回文链表
     * @param head
     */
    public static boolean isPalindrome(Node head){
        return true;
    }

    //TODO
    /**
     * 有环链表中距离p节点的最远节点
     * @param head
     * @param p
     * @return
     */
    public static Node farthestNode(Node head, Node p){
        return null;
    }

    //TODO
    /**
     * 判断两个无环链表中是否相交
     * @param head1
     * @param head2
     * @return
     */
    public static boolean isCrossed(Node head1,Node head2){
        return false;
    }

    public static void testBasicFunctions() {
        DemoSingleLinkedList2 demo = new DemoSingleLinkedList2();

        System.out.println("==================================");
        demo.printAll();

        System.out.println("==================================insertAll {10,20,30,40}");
        demo.insertAll(new int[]{10, 20, 30, 40});
        demo.printAll();

        System.out.println("==================================findByValue 20");
        Node value20 = demo.findByValue(20);
        System.out.println(value20);

        System.out.println("==================================findByValue 40");
        Node value40 = demo.findByValue(40);
        System.out.println(value40);

        System.out.println("==================================findByValue 0");
        Node value0 = demo.findByValue(0);
        System.out.println(value0);

        System.out.println("==================================findByIndex 0");
        Node index0 = demo.findByIndex(0);
        System.out.println(index0);

        System.out.println("==================================findByIndex 3");
        Node index3 = demo.findByIndex(3);
        System.out.println(index3);

        System.out.println("==================================findByIndex 4");
        Node index4 = demo.findByIndex(4);
        System.out.println(index4);

        System.out.println("==================================insertToHead 0");
        demo.insertToHead(0);
        demo.printAll();

        System.out.println("==================================deleteByNode index3");
        demo.deleteByNode(demo.findByIndex(3));
        demo.printAll();

        System.out.println("==================================deleteByValue 20");
        demo.deleteByValue(20);
        demo.printAll();

        System.out.println("==================================deleteByValue 30");
        demo.deleteByValue(30);
        demo.printAll();

        System.out.println("==================================inverseLinkList_head");
        demo.mHead = demo.inverseLinkList_head(demo.mHead);
        demo.printAll();

        System.out.println("==================================reverse");
        demo.mHead = reverse(demo.mHead);
        demo.printAll();

        System.out.println("==================================reverse_Test");
        demo.mHead = reverse_Test(demo.mHead);
        demo.printAll();


        System.out.println("==================================inverseLinkList_head_Test2");
        demo.mHead = demo.inverseLinkList_head_Test2(demo.mHead);
        demo.printAll();

        System.out.println("==================================reverse_Test2");
        demo.mHead = demo.reverse_Test2(demo.mHead);
        demo.printAll();
    }

    public static void testCircleFunctions(){
        System.out.println("==================================");
        DemoSingleLinkedList2 demoCircularLinkedList = new DemoSingleLinkedList2();
        demoCircularLinkedList.insertAll(new int[]{10,20,30,40,50,60,70,80,90,100});
        demoCircularLinkedList.printAll();

        System.out.println("==================================");
        Node nodeEnd = demoCircularLinkedList.findByValue(100);
        System.out.println("nodeEnd:"+nodeEnd );

        System.out.println("==================================");
        Node nodeJoin = demoCircularLinkedList.findByValue(40);
        System.out.println("nodeJoin:"+nodeJoin );

        nodeEnd.next = nodeJoin;

        System.out.println("==================================isCircularLinkedList");
        boolean isCircular = isCircularLinkedList(demoCircularLinkedList.mHead);
        System.out.println("isCircular "+isCircular);

        System.out.println("==================================getJoinNode");
        Node joinNode = getJoinNode(demoCircularLinkedList.mHead);
        System.out.println("joinNode "+joinNode);


        System.out.println("==================================getCircleLength");
        int circleLength = getCircleLength(demoCircularLinkedList.mHead);
        System.out.println("circleLength "+circleLength);

        System.out.println("==================================getTotalLength");
        int totalLength = getTotalLength(demoCircularLinkedList.mHead);
        System.out.println("totalLength "+totalLength);
    }

    public static void main(String[] args) {
        testBasicFunctions();

        System.out.println("***********************************************");

        testCircleFunctions();
    }


}
