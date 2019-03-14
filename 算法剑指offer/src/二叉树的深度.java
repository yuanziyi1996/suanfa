import com.sun.org.apache.regexp.internal.RE;
import org.apache.poi.hssf.record.RightMarginRecord;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;

public class 二叉树的深度 {
    public static int TreeDepth(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        TreeNode last=root;//当前行的最后一个节点——初始值
        TreeNode nlast=null;//下一行的最后一个节点值
        int depth=0;
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();

            if(cur.left!=null){
                queue.offer(cur.left);
                nlast=cur.left;
            }
            if(cur.right!=null){
                queue.offer(cur.right);
                nlast=cur.right;
            }
            if(cur==last){
                depth++;
                last=nlast;
            }
        }
        return depth;
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
        System.out.println(TreeDepth(root));
    }
}
