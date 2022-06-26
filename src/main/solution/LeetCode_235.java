package main.solution;

import main.resources.TreeNode;

public class LeetCode_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ancestor = root;
		while(true) {
			if(p.val < ancestor.val && q.val < ancestor.val) {
				ancestor = ancestor.left;
			} else if(p.val > ancestor.val && q.val > ancestor.val) {
				ancestor = ancestor.right;
			} else {
				break;
			}
		}
		return ancestor;
	}
}