package LeeCode.链表;

public class 链表翻转 {
    public static Node ReverseIteratively(Node head){
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
