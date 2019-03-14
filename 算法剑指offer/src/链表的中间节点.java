import javax.security.auth.callback.TextOutputCallback;

public class 链表的中间节点 {
    public static  Node solution(Node node){
        if(node==null)
            return node;
        Node one=node;
        Node two = node;
        while (two.next!=null){
            one=one.next;
            two=two.next;
            if(two.next!=null){
                two=two.next;
            }
        }
        return one;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(5);
        Node node2 = new Node(6);
        Node node3 = new Node(9);
        Node node4 = new Node(7);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        head.next = node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;


        System.out.println( solution(head).val);
    }
}
