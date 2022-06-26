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
 * @create 2022/6/1 14:08
 */
public class LeetCode_473 {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1<<n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 0; s < (1<<n); s++) {
            for (int k = 0; k < n; k++) {
                if((s & (1 << k)) == 0) {
                    continue;
                }
                int s1 = s & ~(1 << k);
                if(dp[s1] >=0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1<<n)-1] == 0;
    }
}
