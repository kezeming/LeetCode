package main.solution;

import main.resources.TreeNode;

import java.util.*;

public class LeetCode_1161 {
    private List<Integer> sum = new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        int ans = 0;
        for (int i = 0; i < sum.size(); i++) {
            if(sum.get(i) > sum.get(ans)) {
                ans = i;
            }
        }
        return ans;
    }

    public void dfs(TreeNode node, int level) {
        if(level == sum.size()) {
            sum.add(node.val);
        } else {
            sum.set(level, sum.get(level) + node.val);
        }
        if(node.left != null) {
            dfs(node.left, level + 1);
        }
        if(node.right != null) {
            dfs(node.right, level + 1);
        }
    }
}
