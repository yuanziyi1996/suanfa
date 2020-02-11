package LeeCode.树;

import java.util.Stack;

public class 二叉树深度优先遍历 {
//思路是肯定是要利用栈来思考问题然后先要把右子树放入占中，因为先进先出。所以左边的现出来。
    public static int TreeDepth(TreeNode root){
          if(root==null)
            return 0;
        Stack<TreeNode> stack =new Stack<>();
        stack.push(root);
        int length=1;
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            System.out.println(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
                length++;
            }
            if(cur.left!=null){
                stack.push(cur.left);
                length++;
            }
        }
        return length;
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
        System.out.println("result = "+TreeDepth(root));
    }
}
