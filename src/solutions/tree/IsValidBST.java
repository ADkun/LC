package solutions.tree;

import tree.TreeNode;

public class IsValidBST {

    private int prev;

    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        if (root == null) return true;
        if (root.left != null) {
            isValidBST(root.left);
        }
        if (root.val <= prev) return false;
        if (root.right != null) {
            isValidBST(root.right);
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;
        if (root.val <= findMax(root.left) || root.val >= findMin(root.right))
            return false;
        if (!isValidBST3(root.left) || !isValidBST3(root.right)) return false;
        return true;
    }

    private Integer findMin(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root.val;
        return findMin(root.left);
    }

    private Integer findMax(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root.val;
        return findMax(root.right);
    }
}
