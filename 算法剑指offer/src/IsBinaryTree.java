class IsBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(6);
        treeNode1.left = new TreeNode(2);
        treeNode1.left.left = new TreeNode(4);
        treeNode1.left.left.left = new TreeNode(5);
        treeNode1.left.left.right = new TreeNode(6);
        treeNode1.left.left.right.left = new TreeNode(7);
        treeNode1.left.left.right.right = new TreeNode(8);
        treeNode1.right = new TreeNode(3);
        treeNode2.left = new TreeNode(7);
        treeNode2.right = new TreeNode(8);
        boolean b = HasSubtree(treeNode1, treeNode2);
        System.out.println(b);
    }
/*
判断是否含有子树
 */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为空的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配，左右两边同时相等的时候才会返回true。
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}
