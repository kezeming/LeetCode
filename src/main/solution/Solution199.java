package main.solution;

import main.resources.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 简化实现
class Solution199 {
	List<Integer> ret;
	public List<Integer> rightSideView(TreeNode root) {
		ret = new ArrayList<Integer>();
		dfs(root, 0);
		return ret;
	}
	public void dfs(TreeNode node, int depth) {
		if(node == null)
			return ;
		if(depth == ret.size())
			ret.add(node.val);
		dfs(node.right, depth + 1);
		dfs(node.left, depth + 1);
	}
}