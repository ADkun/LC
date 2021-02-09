package solutions.tree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    public int maxDepth3(TreeNode root) {
        // DFS
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int depth) {
        if (root == null) return 0;
        return Math.max(Math.max(dfs(root.left, depth + 1), dfs(root.right, depth + 1)), depth + 1);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                --size;
            }
            ++ans;
        }
        return ans;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
