import java.nio.file.attribute.DosFileAttributes;

public class Test {
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        boolean flag=false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                flag=doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!flag) {
                flag = HasSubtree(root1.left, root2);
            }
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2){
        if(node1==null)
            return false;
        if (node2==null)
            return true;
        if(node1.val!=node2.val)
            return false;
        return doesTree1HaveTree2(node1.left,node2.left)&&doesTree1HaveTree2(node1.right,node2.right);
    }
}
