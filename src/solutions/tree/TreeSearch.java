package solutions.tree;

import tree.BinarySearchTree;

public class TreeSearch {

  public static int ts(int[] arr, int x) {
    BinarySearchTree bst = new BinarySearchTree(arr);
    return bst.find(x);
  }
}
