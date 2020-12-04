package LeeCode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树层次遍历加换行符迭代方式 {
    public static void visitTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode cur;
        //当前行的最后一个节点——初始值，root
        TreeNode last = root;
        //下一行的最后一个节点
        TreeNode nlast = null;
        List<Integer> layers = new ArrayList<>();
        while (!queue.isEmpty()) {
            //弹出队列中的最先进入队列的那一个
            cur = queue.poll();
            System.out.print(cur.val + " ");
            layers.add(cur.val);
            System.out.println(layers);
            if (cur.left != null) {
                queue.offer(cur.left);
                //迭代的nlast
                nlast = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                //迭代的nlast
                nlast = cur.right;
            }
            //当前节点是当前最右时，nlast的迭代也就结束了，它已经是最右了，赋给last
            if (cur == last) {
                System.out.println("layers = " + layers);
                layers.clear();
                last = nlast;
                //直接都用println了，用----假装换行，重在思路，不要在意细节
                System.out.println("---------");
                //这个判断为什么要放到左右节点进队之后呢，因为还要迭代nlast呢，很关键
            }
        }
    }

    public static List<List<Integer>> cengcibianli(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        int cengshu = 0;
        while (!queue.isEmpty()) {
            List<Integer> layers = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                layers.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            cengshu += 1;
            result.add(layers);
        }
        System.out.println("这棵树有 " + cengshu + " 层");
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.left.right = new TreeNode(9);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
       /* TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);*/
        visitTree(root);
        System.out.println(cengcibianli(root));
    }

}
