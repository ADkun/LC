package tree;

import solutions.array.BinarySearch;
import tree.TreeNode;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree(int[] arr) {
        // 生成一个二叉查找树
        for (int i = 0; i < arr.length; ++i) {
            TreeNode newNode = new TreeNode(arr[i], null, null);
            newNode.index = i;
            add(this.root, newNode);
        }
    }

    public void add(TreeNode root, TreeNode node) {
        if (this.root == null) {
            this.root = node;
            return;
        }
        TreeNode nextNode;
        if (node.val < root.val) {
            if (root.left == null) {
                root.left = node;
            } else {
                add(root.left, node);
            }
        } else if (node.val > root.val) {
            if (root.right == null) {
                root.right = node;
            } else {
                add(root.right, node);
            }
        }
    }

    public int find(int x) {
        return find(root, x);
    }

    private int find(TreeNode root, int x) {
        if (root == null) return -1;
        if (root.val == x) {
            return root.index;
        }
        int indexLeft, indexRight;
        if ((indexLeft = find(root.left, x)) != -1)
            return indexLeft;
        if ((indexRight = find(root.right, x)) != -1)
            return indexRight;

        return -1;
    }
}
