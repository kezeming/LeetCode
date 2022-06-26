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
 * @create 2022/6/2 09:48
 */
public class LeetCode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(root.val == key) {
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.right == null) {
                return root.left;
            }
            if(root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}
