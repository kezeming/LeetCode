/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import main.resources.TreeNode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/5/11 10:42
 */
public class LeetCode_449 {
    StringBuffer sb = new StringBuffer();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        preOrder(root);
        return sb.toString().substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) {
            return null;
        }
        String[] preorder = data.split(",");
        String[] inorder = data.split(",");
        int n = preorder.length;
        Arrays.sort(inorder, (a, b) -> {
            int l1 = a.length(), l2 = b.length();
            if(l1 != l2) {
                return l1 - l2;
            } else {
                for(int i=0;i<l1;i++) {
                    if(a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
            }
            return 0;
        });
        TreeNode root = build(preorder, 0, n-1, inorder, 0, n-1);
        return root;
    }

    public TreeNode build(String[] preOrder, int s1, int e1, String[] inOrder, int s2, int e2) {
        if(s1 > e1) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(preOrder[s1]));
        int idx = -1;
        for(int i=s2;i<=e2;i++) {
            if(inOrder[i].equals(preOrder[s1])) {
                idx = i;
            }
        }
        root.left = build(preOrder, s1+1, s1+idx-s2, inOrder, s2, idx-1);
        root.right = build(preOrder, s1+idx-s2+1, e1, inOrder, idx+1, e2);
        return root;
    }

    public void preOrder(TreeNode node) {
        sb.append(node.val).append(",");
        if(node.left != null) {
            preOrder(node.left);
        }
        if(node.right != null) {
            preOrder(node.right);
        }
    }
}
