/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/5/20 10:56
 */
public class LeetCode_436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] ss = new int[n][2], es = new int[n][2];
        for(int i=0;i<n;i++) {
            ss[i] = new int[]{intervals[i][0], i};
            es[i] = new int[]{intervals[i][1], i};
        }
        Arrays.sort(ss, (a, b) -> a[0] - b[0]);
        Arrays.sort(es, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            int[] cur = es[i];
            int loc = cur[0], idx = cur[1];
            int j = 0;
            while (j<n && ss[j][0] < loc) {
                j++;
            }
            ans[idx] = j == n ? -1 : ss[j][1];
        }
        return ans;
    }
}
