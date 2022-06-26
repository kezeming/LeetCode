package main.solution;

import main.resources.TreeNode;

import java.util.*;

public class LeetCode_230 {
	public int kthSmallest(TreeNode root, int k) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		while(root != null || !stack.isEmpty()) { // 注意这里的条件
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			k--;
			if(k == 0) {
				break;
			}
			root = root.right;
		}
		return root.val;
	}
}



