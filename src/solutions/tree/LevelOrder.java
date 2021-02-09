package solutions.tree;

import com.sun.source.tree.Tree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    private List<List<Integer>> list;

    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (list.size() < level + 1)
            list.add(new ArrayList<>());

        list.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }


    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> newList = new LinkedList<>();

            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    newList.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!newList.isEmpty())
                list.add(newList);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode r1 = root.right = new TreeNode(20);
        r1.left = new TreeNode(15);
        r1.right = new TreeNode(7);
//        levelOrder(root);
    }
}
