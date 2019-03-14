public class 二叉树中找一条和最大的路径 {
    public static int max = Integer.MIN_VALUE;
    public static int solution(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int left = solution(root.left);
        int right = solution(root.right);
        max = Math.max(max, left + right + root.val);// 更新max值
        return Math.max(left, right) + root.val;
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
        solution(root);
        System.out.println(max);
    }
}
