/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/9/8 15:56
 */
public class LeetCode_667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int idx = 0;
        for (int i=1; i<n-k; i++) {
            ans[idx] = i;
            idx++;
        }
        for (int i=n-k, j=n; i<=j; i++, j--) {
            ans[idx] = i;
            idx++;
            if (i != j) {
                ans[idx] = j;
                idx++;
            }
        }
        return ans;
    }
}
