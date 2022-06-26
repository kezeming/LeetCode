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
 * @create 2022/4/20 20:11
 */
public class LeetCode_426 {
    TreeNode head = null, pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        TreeNode curr1 = head;
        while(curr1 != null) {
            System.out.print(curr1.val + " ");
            curr1 = curr1.right;
        }
        return head;
    }

    public void inOrder(TreeNode cur) {
        if(cur == null) {
            return ;
        }
        if(cur.left == null && cur.right == null && pre == null) {
            pre = cur;
            head = pre;
            return ;
        }
        inOrder(cur.left);
        if(pre != null) {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        inOrder(cur.right);
    }
}