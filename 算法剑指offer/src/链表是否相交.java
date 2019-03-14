public class 链表是否相交 {
    // 判断两个单链表是否相交
    /**
     * 如果两个链表相交于某一节点，那么在这个相交节点之后的所有节点都是两个链表所共有的。
     * 也就是说，如果两个链表相交，那么最后一个节点肯定是共有的。
     * 先遍历第一个链表，记住最后一个节点，然后遍历第二个链表，
     * 到最后一个节点时和第一个链表的最后一个节点做比较，如果相同，则相交，
     * 否则不相交。时间复杂度为O(len1+len2)，因为只需要一个额外指针保存最后一个节点地址， 空间复杂度为O(1)
     */
    public static boolean isIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }

        Node tail1 = head1;
        // 找到链表1的最后一个节点
        while (tail1.next != null) {
            tail1 = tail1.next;
        }

        Node tail2 = head2;
        // 找到链表2的最后一个节点
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        return tail1 == tail2;
    }
}
