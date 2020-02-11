package LeeCode.树;

public class 二叉树先根遍历 {


    public static void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+"  ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    public static void main(String[] args) {
        /**
         *           1
         *         /  \
         *        2    3
         *       / \   / \
         *       4  5  7   8
         *           \
         *            6
         */
        TreeNode root =new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(8);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        preOrderTraverse1(root);
    }
}
