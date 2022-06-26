package main.solution;

import main.resources.TreeNode;

public class LeetCode_129 {
	int ret = 0;
	public int sumNumbers(TreeNode root) {
		backtrace(root, 0);
		return ret;
	}
	public void backtrace(TreeNode root, int currVal) {
		if(root.left == null && root.right == null) {
			currVal = currVal*10 + root.val;
			ret += currVal;
			return;
		}
		currVal = currVal*10 + root.val;
		if(root.left != null) {
			backtrace(root.left, currVal);
		}
		if(root.right != null) {
			backtrace(root.right, currVal);
		}
	}
}