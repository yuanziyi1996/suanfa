public class 链表相交的第一个节点 {

    /**
     * 求两个单链表相交的第一个节点 对第一个链表遍历，计算长度len1，同时保存最后一个节点的地址。
     * 对第二个链表遍历，计算长度len2，同时检查最后一个节点是否和第一个链表的最后一个节点相同，若不相同，不相交，结束。
     * 两个链表均从头节点开始，假设len1大于len2
     * ，那么将第一个链表先遍历len1-len2个节点，此时两个链表当前节点到第一个相交节点的距离就相等了，然后一起向后遍历，直到两个节点的地址相同。
     * 时间复杂度，O(len1+len2)
     *
     *              ----    len2
     *                   |__________
     *                   |
     *       ---------   len1
     *       |---|<- len1-len2
     */
    public static Node solution(Node node1,Node node2){
        if(node1==null||node2==null)
            return null;
        int length1=0;
        int length2=0;
        while (node1.next!=null){
            node1=node1.next;
            length1++;
        }
        while (node2.next!=null){
            node2=node2.next;
            length2++;
        }
        Node n1=node1;
        Node n2=node2;

        //以下两处用于把较长的一个跨不不爱的
        if (length1 > length2) {
            int k = length1 - length2;
            while (k != 0) {
                n1 = n1.next;
                k--;
            }
        } else {
            int k = length2 - length1;
            while (k != 0) {
                n2 = n2.next;
                k--;
            }
        }

        while (n1!=n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }
}
