package solutions.tree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    public int bfs(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int lay = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return lay + 1;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ++lay;
        }
        return lay;
    }

    public int minDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return depth + 1;

        int minDepth1 = 0;
        int minDepth2 = 0;
        if (root.left != null) minDepth1 = dfs(root.left, depth + 1);
        if (root.right != null) minDepth2 = dfs(root.right, depth + 1);
        return minDepth1 > minDepth2 ? minDepth2 : minDepth1;
    }
}
