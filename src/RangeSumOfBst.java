import java.util.ArrayList;
import java.util.List;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBst {

    public static void main(String[] args) {
        /**
         * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
         * 输出：32
         */
        TreeNode root3 = new TreeNode(3);
        TreeNode root7 = new TreeNode(7);
        TreeNode root5 = new TreeNode(5, root3, root7);
        TreeNode root18 = new TreeNode(18);
        TreeNode root15 = new TreeNode(15, null, root18);
        TreeNode root10 = new TreeNode(10, root5, root15);
        System.out.println("root1: " + root10);
        RangeSumOfBst rsob = new RangeSumOfBst();
        int result1 = rsob.rangeSumBST(root10, 7, 15);
        System.out.println("result1: " + result1);

        /**
         * 输入：root = [10,5,15,3,7,13,18,1,null,6,null], L = 6, R = 10
         * 输出：23
         */
        TreeNode root1 = new TreeNode(1);
        root3 = new TreeNode(3, root1, null);
        TreeNode root6 = new TreeNode(6);
        root7 = new TreeNode(7, root6, null);
        root5 = new TreeNode(5, root3, root7);
        TreeNode root13 = new TreeNode(13);
        root18 = new TreeNode(18);
        root15 = new TreeNode(15, root13, root18);
        root10 = new TreeNode(10, root5, root15);
        System.out.println("root2: " + root10);
        int result2 = rsob.rangeSumBST(root10, 6, 10);
        System.out.println("result2: " + result2);
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        boolean sumRight = true;
        boolean sumLeft = true;
        if (root.val < L) {
            sumLeft = false;
        } else if (root.val > R) {
            sumRight = false;
        } else {
            result += root.val;
        }
        if (sumLeft && root.left != null) {
            result += rangeSumBST(root.left, L, R);
        }
        if (sumRight && root.right != null) {
            result += rangeSumBST(root.right, L, R);
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
