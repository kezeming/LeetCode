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
 * @create 2022/9/4 14:02
 */
public class LeetCode_1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] val1 = new int[m];
        int[] val2 = new int[n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                val1[i] += mat[i][j];
                val2[j] += mat[i][j];
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (val1[i] == 1 && val2[j] == 1 && mat[i][j] == 1) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
