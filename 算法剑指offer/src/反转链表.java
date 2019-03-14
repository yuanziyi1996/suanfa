public class 反转链表 {

    //注意还可以用栈来实现
    public static Node reverseNode(Node head){
        // 如果链表为空或只有一个节点，无需反转，直接返回原链表表头
        if(head == null || head.next == null)
            return head;

        Node pre=head;
        Node cur=head.next;
        Node last=null;
        while(cur!=null){
            last=cur.next;
            cur.next=pre;
            pre=cur;
            cur=last;
        }
        head.next=null;//这一步是必须要使用的反转之后，head节点就变为最后一个节点
        return pre;
    }

    public static void main(String[] args) {
        Node node=new Node(1);
        node.next=new Node(7);
        node.next.next=new Node(2);
        node.next.next.next=new Node(3);
        node.next.next.next.next=new Node(4);
        node.next.next.next.next.next=new Node(5);
        node.next.next.next.next.next.next=new Node(6);
        Node node1=reverseNode(node);
        while (node1!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
}
