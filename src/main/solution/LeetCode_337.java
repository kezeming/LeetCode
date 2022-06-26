package main.solution;

import main.resources.TreeNode;

public class LeetCode_337 {
	public int rob(TreeNode root) {
		int[] rootStatus = dfs(root);
		return Math.max(rootStatus[0], rootStatus[1]);
	}

	public int[] dfs(TreeNode node) {
		if(node == null) {
			return new int[]{0, 0};
		}
		int[] l = dfs(node.left);
		int[] r = dfs(node.right);
		int select = node.val + l[1] + r[1];
		int notSelect = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
		return new int[]{select, notSelect};
	}
}