import java.util.LinkedList;

public class 第k层的节点个数 {
    /***********************************************************************
     7. 求二叉树第K层的节点个数:getNodeNumKthLevelRec(递归) getNodeNumKthLevel(迭代)
     **********************************************************************/
    /**
     * 求二叉树第K层的节点个数   递归解法：
     * （1）如果二叉树为空或者k<1返回0
     * （2）如果二叉树不为空并且k==1，返回1
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     *
     * 求以root为根的k层节点数目 等价于 求以root左孩子为根的k-1层（因为少了root那一层）节点数目 加上
     * 以root右孩子为根的k-1层（因为少了root那一层）节点数目
     *
     * 所以遇到树，先把它拆成左子树和右子树，把问题降解
     *
     */
    public static int getNodeNumKthLevelRec(TreeNode root, int k){
        if(root==null || k<1)
            return 0;
        if(k==1)
            return 1;

        int leftNum = getNodeNumKthLevelRec(root.left, k-1);
        int rightNum = getNodeNumKthLevelRec(root.right, k-1);
        return leftNum+rightNum;

    }
    /**
     *  求二叉树第K层的节点个数   迭代解法：
     *  同getDepth的迭代解法
     */
    public static int getNodeNumKthLevel(TreeNode root, int k){
        if(root==null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);   // 先将root存入队列

        int i = 1; // 用来记录当前层数,和k做比较
        int currentLevelNode = 1;
        int nextLevelNode = 0;
        // 当队列不为空，且当前层数小于k时，执行以下循环
        while(!queue.isEmpty() && i<k){ // 当输入k大于深度时，返回0;
            TreeNode cur = queue.remove();
            currentLevelNode--;

            if(cur.left!=null){  // 处理左子树
                queue.add(cur.left);
                nextLevelNode++;
            }

            if(cur.right!=null){  // 处理右子树
                queue.add(cur.right);
                nextLevelNode++;
            }

            if(currentLevelNode==0){  // 当前层的节点全部遍历完，则开始处理下一层。
                currentLevelNode = nextLevelNode;
                nextLevelNode = 0;
                i++;
            }
        }
        // 当循环结束时，说明到达了K层
        return currentLevelNode;
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
        System.out.println(getNodeNumKthLevelRec(root,4));
    }
}
