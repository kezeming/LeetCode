/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import main.resources.TreeNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/9/2 12:21
 */
public class LeetCode_687 {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0, cur = 0, l = dfs(root.left), r = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            ans = l + 1;
            cur += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            ans = Math.max(ans, r + 1);
            cur += r + 1;
        }
        max = Math.max(max, cur);
        return ans;
    }
}
