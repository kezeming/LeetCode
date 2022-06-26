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
 * @create 2022/5/16 14:45
 */

/**
 * 二叉搜索树找后继结点
 */
public class LeetCode_2562 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root.val <= p.val)
            return inorderSuccessor(root.right, p);
        TreeNode ans = inorderSuccessor(root.left, p);
        return ans == null ? root : ans;
    }
}
