package LeeCode.链表;

public class 判断链表是否有环状 {
    public static class Node{
        private int value ;
        private Node next;
        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    //判断是否有环
    public static  boolean circleList(Node node){
        if (node==null || node.next ==null){
            return false;
        }

        // 快慢节点，慢节点一次走一步，快捷点一次走两步，如果有环状，肯定会追上
        Node node1 = node;
        Node node2 = node;
        int s1 = 0;
        int s2 = 0;
        int count = 1;
        while (node2 != null  && node2.next!=null){
            node1 = node1.next;
            node2 = node2.next.next;
            s1+=1;
            s2+=2;
            if(node1 == node2){
                node1 = node1.next;
                while (node1 != node2){
                    count++;
                    node1 = node1.next;
                }
                //count 就是环状部分的长度
                System.out.println(count);
                return true;
            }
        }
        return false;
    }

    //求环状部分的起始点
    public static Node circleStart(Node node){
        if(node == null || node.next ==null){
            return null;
        }

        Node node1 = node;
        Node node2 = node;
        while (node2!=null && node2.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
            if(node1 == node2){
                node1 = node;
                while (node1!=node2){
                    node1 = node1.next;
                    node2 = node2.next;
                    if(node1 == node2){
                        return node1;
                    }
                }
            }
            return node1;
        }
        return null;
    }



    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        Node node = node1;
        System.out.println(circleList(node));
        System.out.println(circleStart(node).getValue());

    }

}
