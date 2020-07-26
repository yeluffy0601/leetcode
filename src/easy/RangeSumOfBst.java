package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBst {

    public static void main(String[] args) {
        /**
         * 输入：node = [10,5,15,3,7,null,18], L = 7, R = 15
         * 输出：32
         */
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5, node3, node7);
        TreeNode node18 = new TreeNode(18);
        TreeNode node15 = new TreeNode(15, null, node18);
        TreeNode node10 = new TreeNode(10, node5, node15);
        System.out.println("node1: " + node10);
        RangeSumOfBst rsob = new RangeSumOfBst();
        int result1 = rsob.rangeSumBST(node10, 7, 15);
        System.out.println("result1: " + result1);

        /**
         * 输入：node = [10,5,15,3,7,13,18,1,null,6,null], L = 6, R = 10
         * 输出：23
         */
        TreeNode node1 = new TreeNode(1);
        node3 = new TreeNode(3, node1, null);
        TreeNode node6 = new TreeNode(6);
        node7 = new TreeNode(7, node6, null);
        node5 = new TreeNode(5, node3, node7);
        TreeNode node13 = new TreeNode(13);
        node18 = new TreeNode(18);
        node15 = new TreeNode(15, node13, node18);
        node10 = new TreeNode(10, node5, node15);
        System.out.println("node2: " + node10);
        int result2 = rsob.rangeSumBST(node10, 6, 10);
        System.out.println("result2: " + result2);
    }

    public int rangeSumBST(TreeNode node, int L, int R) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        boolean sumRight = true;
        boolean sumLeft = true;
        if (node.val < L) {
            sumLeft = false;
        } else if (node.val > R) {
            sumRight = false;
        } else {
            result += node.val;
        }
        if (sumLeft && node.left != null) {
            result += rangeSumBST(node.left, L, R);
        }
        if (sumRight && node.right != null) {
            result += rangeSumBST(node.right, L, R);
        }
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
            if (node.left == null) {
                sb.append(",null");
            } else {
                flag = true;
                sb.append(",");
                sb.append(node.left.val);
                context.add(node.left);
            }
            if (node.right == null) {
                sb.append(",null");
            } else {
                flag = true;
                sb.append(",");
                sb.append(node.right.val);
                context.add(node.right);
            }
            return flag ? sb.toString() : "";
        }

    }

}
