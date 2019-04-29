package mydemo.linkedlist._07_linkedlist;

public class DemoSingleLinkedList implements ISingleLinkedList {

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


    public static void printAll(Node headNode) {
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

    public static Node reverse_Test3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head;
        Node prev = null;
        Node next = cur.next;
        while (next != null) {
            cur.next = prev;
            prev = cur; //TODO keep watch
            cur = next;
            next = next.next;
        }
        cur.next = prev; //TODO keep watch
        return null;
    }

    public static Node reverse_Test4(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node prev = null;
        Node next = cur.next;
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
     * 快慢指针法： 两个指针同时从链表头移动 慢指针每次移动1步； 快指针每次移动2步；
     * 快慢指针如果重合说明一定有环 证明：
     * https://blog.csdn.net/sinat_35261315/article/details/79205157
     *
     * @param head
     * @return null：没有环；非null：快慢指针的相遇点
     */
    public static Node isCircular(Node head) {
        Node slow = head;
        Node fast = head;

        //TODO 注意while的判断中 都是用fast判断
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public static boolean isCircularLinkedList(Node head) {
        return isCircular(head) != null;
    }

    /**
     * 获取环的长度
     *
     * @param head
     * @return
     */
    public static int getCircleLength(Node head) {
        Node repeatNode = isCircular(head);
        if (repeatNode == null) {
            return 0;
        } else {
            Node slow = repeatNode;
            int count = 0;
            while (slow.next != repeatNode) {
                slow = slow.next;
                count++;
            }
            return count + 1;
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
     *
     * @param head
     * @return
     */
    public static Node getJoinNode(Node head) {
        Node meetPosition = isCircular(head);
        Node a = head;
        Node p = meetPosition;
        while (a != p) {
            a = a.next;
            p = p.next;
        }
        return a;
    }

    /**
     * 带有环的单向链表的全长
     *
     * @param head
     * @return
     */
    public static int getTotalLength(Node head) {
        int headToJoinLength = 0;
        Node joinNode = getJoinNode(head);
        Node p = head;
        while (p != joinNode) {
            p = p.next;
            headToJoinLength++;
        }
        return headToJoinLength + getCircleLength(head);
    }

    @Override
    public Node inverseLinkList(Node p) {
        return null;
    }

    /**
     * 两个有序的链表合并(只能合并递增排序的链表)
     *
     * @param headA
     * @param headB
     */
    public static Node mergeIncreasedLinkedList(Node headA, Node headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;

        Node curA = headA;
        Node curB = headB;
        Node p;
        Node mergeCur = null;

        while (curA != null || curB != null) {
            if (curA == null) {
                p = curB;
                curB = curB.next;
            } else if (curB == null) {
                p = curA;
                curA = curA.next;
            } else {
                if (curA.data < curB.data) {
                    p = curA;
                    curA = curA.next;
                } else {
                    p = curB;
                    curB = curB.next;
                }
            }
            p.next = mergeCur;
            mergeCur = p;
        }
        //reverse
        return reverse_Test4(mergeCur);
    }

    /**
     * 使用递归的方式
     *
     * @param nodeA
     * @param nodeB
     * @return
     */
    public static Node mergeIncreasedLinkedList2(Node nodeA, Node nodeB) {
        if (nodeA == null) {
            return nodeB;
        }
        if (nodeB == null) {
            return nodeA;
        }
        Node merge = null;
        if (nodeA.data < nodeB.data) {
            merge = nodeA;
            merge.next = mergeIncreasedLinkedList2(nodeA.next, nodeB);
        } else {
            merge = nodeB;
            merge.next = mergeIncreasedLinkedList2(nodeA, nodeB.next);
        }

        return merge;
    }

    /**
     * 删除链表倒数第 n 个结点
     *
     * @param head
     * @param pos
     */
    public static Node deleteLastNode(Node head, int pos) {
        if (pos <= 0 || head == null) return head;
        Node early = head;
        Node late = null;
        int count = 0;
        while (early.next != null) {
            early = early.next;
            if (count >= pos) {
                if(late == null){
                    late = head.next;
                }else {
                    late = late.next;
                }
            }
            count++;
        }
        System.out.println("deleteLastNode previous node = "+late);
        if(late!=null) {
            late.next = late.next.next;
        }

        return head;
    }


    public static Node getLastNode(Node head, int pos) {
        if (pos <= 0 || head == null) return null;
        Node early = head;
        Node late = null;
        int count = 0;
        while (early.next != null) {
            early = early.next;
            if (count == pos - 1) {
                late = head.next;
            } else if (count > pos - 1) {
                late = late.next;
            }
            count++;
        }
        return late;
    }

    /**
     * 求链表的中间结点
     *
     * @param head
     */
    public static Node getMiddleNode(Node head) {
        if(head == null || head.next==null) return head;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null){
            System.out.println("even(偶数个)");
        }else{
            System.out.println("odd(奇数个)");
        }

        return slow;
    }


    /**
     * 是否为回文链表
     *
     * @param head
     */
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return false;
        // 找到中间结点
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHead = slow.next;

        Node firstEndNext;
        if (fast.next != null) {
            firstEndNext = slow.next;
        } else {
            firstEndNext = slow;
        }

        //第一部分逆序
        Node firstHead = head;
        Node next = head.next;
        Node prev = null;
        while (next != firstEndNext) {
            firstHead.next = prev;
            prev = firstHead;
            firstHead = next;
            next = next.next;
        }
        firstHead.next = prev;

        //第一部分逆序后 和 第二部分比较
        while (secondHead != null && firstHead != null) {
            if (secondHead.data == firstHead.data) {
                secondHead = secondHead.next;
                firstHead = firstHead.next;
            } else {
                return false;
            }
        }
        if (secondHead == null && firstHead == null) {
            return true;
        } else {
            return false;
        }
    }

    //TODO
    /**
     * 有环链表中距离p节点的最远节点
     *
     * @param head
     * @param p
     * @return
     */
    public static Node farthestNode(Node head, Node p) {
        return null;
    }

    //TODO
    /**
     * 判断两个无环链表中是否相交
     * 思路：将其中一个链表首尾相连 判断另一个链表是否有环 如果有说明相交
     *
     * @param head1
     * @param head2
     * @return
     */
    public static boolean isCrossed(Node head1, Node head2) {
        return false;
    }

    public static void testBasicFunctions() {
        DemoSingleLinkedList demo = new DemoSingleLinkedList();

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

    public static void testCircleFunctions() {
        System.out.println("==================================");
        DemoSingleLinkedList demoCircularLinkedList = new DemoSingleLinkedList();
        demoCircularLinkedList.insertAll(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100});
        demoCircularLinkedList.printAll();

        System.out.println("==================================");
        Node nodeEnd = demoCircularLinkedList.findByValue(100);
        System.out.println("nodeEnd:" + nodeEnd);

        System.out.println("==================================");
        Node nodeJoin = demoCircularLinkedList.findByValue(40);
        System.out.println("nodeJoin:" + nodeJoin);

        nodeEnd.next = nodeJoin;

        System.out.println("==================================isCircularLinkedList");
        boolean isCircular = isCircularLinkedList(demoCircularLinkedList.mHead);
        System.out.println("isCircular " + isCircular);

        System.out.println("==================================getJoinNode");
        Node joinNode = getJoinNode(demoCircularLinkedList.mHead);
        System.out.println("joinNode " + joinNode);


        System.out.println("==================================getCircleLength");
        int circleLength = getCircleLength(demoCircularLinkedList.mHead);
        System.out.println("circleLength " + circleLength);

        System.out.println("==================================getTotalLength");
        int totalLength = getTotalLength(demoCircularLinkedList.mHead);
        System.out.println("totalLength " + totalLength);
    }

    public static void main(String[] args) {
//        testBasicFunctions();
//        System.out.println("***********************************************\n");
//        testCircleFunctions();
//        System.out.println("***********************************************\n");
//        testMergeTwoSortedNodes();

//        System.out.println("***********************************************\n");
//        testGetLastXNode();

        System.out.println("***********************************************\n");
        testIsPalindrome();
    }

    private static void testMergeTwoSortedNodes() {
        System.out.println("==================================A");
        DemoSingleLinkedList llA = new DemoSingleLinkedList();
        llA.insertAll(new int[]{1, 3, 4, 6, 9});
        llA.printAll();

        System.out.println("==================================B");
        DemoSingleLinkedList llB = new DemoSingleLinkedList();
        llB.insertAll(new int[]{2, 5, 7, 8, 10});
        llB.printAll();

        System.out.println("==================================A and B mergeResult: ");
        //合并方法1
        Node mergeHead = mergeIncreasedLinkedList(llA.mHead, llB.mHead);
        printAll(mergeHead);

        //合并方法2
//        Node mergeHead2 = mergeIncreasedLinkedList2(llA.mHead, llB.mHead);
//        printAll(mergeHead2);

        System.out.println("==================================after merge A");
        llA.printAll();
        System.out.println("==================================after merge B");
        llB.printAll();

        System.out.println("==================================node100");
    }

    private static void testGetLastXNode() {
        DemoSingleLinkedList nodes = new DemoSingleLinkedList();
        int[] all = new int[10];
        for (int i = 0; i < all.length; i++) {
            all[i] = i + 1;
        }
        nodes.insertAll(all);
        printAll(nodes.mHead);

        System.out.println("==================================getLastNode");
        Node x = getLastNode(nodes.mHead, 3);
        System.out.println(x);

        System.out.println("==================================getMiddleNode");
        Node middleNode = getMiddleNode(nodes.mHead);
        System.out.println(middleNode);

        System.out.println("==================================delete last 3");
        Node headAfterDeleteX = deleteLastNode(nodes.mHead, 3);
        printAll(headAfterDeleteX);

        System.out.println("==================================getMiddleNode");
        Node middleNode2 = getMiddleNode(nodes.mHead);
        System.out.println(middleNode2);

    }

    private static void testIsPalindrome() {
        DemoSingleLinkedList llA = new DemoSingleLinkedList();
        llA.insertAll(new int[]{1, 3, 4, 6, 9});
        boolean isPalindromeA = isPalindrome(llA.mHead);
        System.out.println("llA : " + isPalindromeA);

        DemoSingleLinkedList llB = new DemoSingleLinkedList();
        llB.insertAll(new int[]{1, 3, 4, 3, 1});
        boolean isPalindromeB = isPalindrome(llB.mHead);
        System.out.println("llB : " + isPalindromeB);

        DemoSingleLinkedList llC = new DemoSingleLinkedList();
        llC.insertAll(new int[]{1, 3, 4, 4, 3, 1});
        boolean isPalindromeC = isPalindrome(llC.mHead);
        System.out.println("llC : " + isPalindromeC);

        DemoSingleLinkedList llD = new DemoSingleLinkedList();
        llD.insertAll(new int[]{1, 3, 1});
        boolean isPalindromeD = isPalindrome(llD.mHead);
        System.out.println("llD : " + isPalindromeD);

        DemoSingleLinkedList llE = new DemoSingleLinkedList();
        llE.insertAll(new int[]{1, 1});
        boolean isPalindromeE = isPalindrome(llE.mHead);
        System.out.println("llE : " + isPalindromeE);

    }


}
