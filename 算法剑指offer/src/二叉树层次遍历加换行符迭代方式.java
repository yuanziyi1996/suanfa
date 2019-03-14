import java.util.LinkedList;
import java.util.Queue;

public class 二叉树层次遍历加换行符迭代方式 {
    public static void visitTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode cur;
        TreeNode last = root;	//当前行的最后一个节点——初始值，root
        TreeNode nlast=null;	//下一行的最后一个节点
        while(!queue.isEmpty()) {
            cur = queue.poll();//弹出队列中的最先进入队列的那一个
            System.out.print(cur.val+" ");
            if (cur.left != null) {
                queue.offer(cur.left);
                nlast = cur.left;//迭代的nlast
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nlast = cur.right;//迭代的nlast
            }
            if (cur == last) {//当前节点是当前最右时，nlast的迭代也就结束了，它已经是最右了，赋给last
                System.out.println("---------");//直接都用println了，用----假装换行，重在思路，不要在意细节
                last = nlast;
            }//这个判断为什么要放到左右节点进队之后呢，因为还要迭代nlast呢，很关键
        }
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(8);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
       /* TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);*/
       visitTree(root);
    }

}
