package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        /**
         * 输入:
         * 	Tree 1                     Tree 2
         *           1                         2
         *          / \                       / \
         *         3   2                     1   3
         *        /                           \   \
         *       5                             4   7
         * 输出:
         * 合并后的树:
         * 	     3
         * 	    / \
         * 	   4   5
         * 	  / \   \
         * 	 5   4   7
         */
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node2, node3);
        TreeNode node44 = new TreeNode(4);
        TreeNode node11 = new TreeNode(1, node44, null);
        TreeNode node77 = new TreeNode(7);
        TreeNode node33 = new TreeNode(3, node77, null);
        TreeNode node22 = new TreeNode(2, node33, node11);
        MergeTwoBinaryTrees mtbt = new MergeTwoBinaryTrees();
        TreeNode result = mtbt.mergeTrees(node1, node22);
        System.out.println("node1: " + node1);
        System.out.println("node2: " + node22);
        System.out.println("result: " + result);

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode result;
        TreeNode t1Left = null;
        TreeNode t1Right = null;
        TreeNode t2Left = null;
        TreeNode t2Right = null;
        if (t1 == null) {
            result = new TreeNode(t2.val);
            t2Left = t2.left;
            t2Right = t2.right;
        } else if (t2 == null) {
            result = new TreeNode(t1.val);
            t1Left = t1.left;
            t1Right = t1.right;
        } else {
            result = new TreeNode(t1.val + t2.val);
            t1Left = t1.left;
            t1Right = t1.right;
            t2Left = t2.left;
            t2Right = t2.right;
        }
        result.left = mergeTrees(t1Left, t2Left);
        result.right = mergeTrees(t1Right, t2Right);
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);
            List<TreeNode> context = new ArrayList<>();
            sb.append(this.print(this, context));
            while (context.size() != 0) {
                sb.append(this.print(context.get(0), context));
                context.remove(0);
            }
            return sb.toString();
        }

        public String print(TreeNode node, List<TreeNode> context) {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            if (node.right == null) {
                sb.append(",null");
            } else {
                flag = true;
                sb.append(",");
                sb.append(node.right.val);
                context.add(node.right);
            }
            if (node.left == null) {
                sb.append(",null");
            } else {
                flag = true;
                sb.append(",");
                sb.append(node.left.val);
                context.add(node.left);
            }
            return flag ? sb.toString() : "";
        }

    }

}
