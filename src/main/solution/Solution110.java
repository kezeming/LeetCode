package main.solution;

import main.resources.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}