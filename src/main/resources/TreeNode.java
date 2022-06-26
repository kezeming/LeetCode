package main.resources;

import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 此构树方法只适合于完全二叉树
    public TreeNode buildTree(List<Integer> lists, int idx) {
        TreeNode root = new TreeNode(lists.get(idx-1));
        if(2*idx <= lists.size()) {
            root.left = buildTree(lists, 2*idx);
        }
        if(2*idx+1 <= lists.size()) {
            root.right = buildTree(lists, 2*idx+1);
        }
        return root;
    }

    public void inOrderTree(TreeNode node) {
        if(node.left != null) {
            inOrderTree(node.left);
        }
        System.out.print(node.val+",");
        if(node.right != null) {
            inOrderTree(node.right);
        }
    }
}
