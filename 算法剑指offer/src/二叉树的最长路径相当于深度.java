/**
 * 利用递归来实现
 */
public class 二叉树的最长路径相当于深度 {
    public static int maxDepth(TreeNode root) {
        if(root==null)//空树
            return 0;
        else if(root.left==null && root.right==null)//只有根结点
            return 1;
        else if(root.left!=null && root.right==null)//只有左子树
            return maxDepth(root.left) + 1;
        else if(root.left==null && root.right!=null)//只有右子树
            return maxDepth(root.right) + 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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

        System.out.println(maxDepth(root));
    }

}
