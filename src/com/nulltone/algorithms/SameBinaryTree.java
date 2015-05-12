package com.nulltone.algorithms;

public class SameBinaryTree {
  public static boolean isSameTree(int[] tree1, int[] tree2) {
    if (tree1[0] != tree2[0] || tree1.length != tree2.length) {
      return false;
    }

    sortTree(tree1);
    sortTree(tree2);

    for (int i = 0; i < tree1.length; i++) {
      if (tree1[i] != tree2[i]) {
        return false;
      }
    }
    return true;
  }

  private static void sortTree(int[] tree) {
    if (tree.length > 2) {
      int lessChildIndex = (tree[1] < tree[2]) ? 1 : 2;
      if (tree[0] < tree[1] && tree[0] >= tree[2]) {
        // Swap children.
        int temp = tree[1];
        tree[1] = tree[2];
        tree[2] = temp;
      } else { 
      }
    }
    // recursively sort child trees.
  }

  private static boolean hasChildren(int[] subtree) {
    return false;
  }
}
