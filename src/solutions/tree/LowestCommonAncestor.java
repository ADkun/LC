package solutions.tree;

import tree.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // 如果左右子树分别有p和q节点，那么该节点就是最近公共祖先节点。
            return root;
        } else if (left != null && right == null) {
            // 说明在左子树
            return left;
        } else {
            // 说明在右子树，由于题目说明p,q肯定存在，所以不需要考虑两子树都为空
            return right;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树版
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor2(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor2(root.right, p, q);
        return root;
    }
}
