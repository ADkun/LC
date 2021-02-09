package solutions.tree;

import tree.TreeNode;

public class InOrderTraverse {

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    public static void inOrderTraverse(TreeNode root) {
        if (root == null) return;
        while (root.right != null) {
            TreeNode left = root.left;
            while (left != null && left.left != null) {
                left = root.left;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(8);
        root.left = l1;
        root.right = r1;

        TreeNode ll1 = new TreeNode(0);
        TreeNode ll2 = new TreeNode(4);
        l1.left = ll1;
        l1.right = ll2;

        TreeNode lll1 = new TreeNode(3);
        TreeNode lll2 = new TreeNode(5);
        ll2.left = lll1;
        ll2.right = lll2;

        TreeNode rr1 = new TreeNode(7);
        TreeNode rr2 = new TreeNode(9);
        r1.left = rr1;
        r1.right = rr2;

        inOrder(root);

    }
}
