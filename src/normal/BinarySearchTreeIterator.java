package normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        /**
         *              7
         *        3           15
         *                 9      20
         *
         * BSTIterator iterator = new BSTIterator(root);
         * iterator.next();    // 返回 3
         * iterator.next();    // 返回 7
         * iterator.hasNext(); // 返回 true
         * iterator.next();    // 返回 9
         * iterator.hasNext(); // 返回 true
         * iterator.next();    // 返回 15
         * iterator.hasNext(); // 返回 true
         * iterator.next();    // 返回 20
         * iterator.hasNext(); // 返回 false
         */
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15, node9, node20);
        TreeNode node7 = new TreeNode(7, node3, node15);
        BinarySearchTreeIterator bsti = new BinarySearchTreeIterator(node7);
        System.out.println(bsti.next());    // 返回 3
        System.out.println(bsti.next());    // 返回 7
        System.out.println(bsti.hasNext()); // 返回 true
        System.out.println(bsti.next());    // 返回 9
        System.out.println(bsti.hasNext()); // 返回 true
        System.out.println(bsti.next());    // 返回 15
        System.out.println(bsti.hasNext()); // 返回 true
        System.out.println(bsti.next());    // 返回 20
        System.out.println(bsti.hasNext()); // 返回 false

        /**
         * null
         */
        bsti = new BinarySearchTreeIterator(null);
        System.out.println(bsti.hasNext());
    }

    private List<TreeNode> nodes;

    private int index;

    public BinarySearchTreeIterator(TreeNode root) {
        this.index = 0;
        this.nodes = new ArrayList<>();
        initNodes(root, this.nodes);
    }

    private void initNodes(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            initNodes(node.left, nodes);
        }
        nodes.add(node);
        if (node.right != null) {
            initNodes(node.right, nodes);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.nodes.get(this.index++).val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index < this.nodes.size();
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
