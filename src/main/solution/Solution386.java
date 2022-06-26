/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/4/18 16:17
 */
public class Solution386 {
    // 转换思路
    // 将「1，n」的树按照字典序添加到答案，本质上是对一颗节点数量为n的多阶树遍历
    // 根节点为0，每个节点有「0，9」共10个子节点
    // 递归 -- dfs
    static class Solution1 {
        List<Integer> ans = new ArrayList<>();
        public List<Integer> lexicalOrder(int n) {
            for (int i = 1; i <= 9; i++) {
                dfs(i, n);
            }
            return ans;
        }

        public void dfs(int cur, int limit) {
            if(cur > limit) return ;
            ans.add(cur);
            for (int i = 0; i <= 9; i++) {
                dfs(cur*10+i, limit);
            }
        }
    }

    // 迭代
    static class Solution2 {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0, j = 1; i < n; i++) {
                ans.add(j);
                if(10*j <= n) {
                    j *= 10;
                } else {
                    while (j%10 == 9 || j+1 > n) {
                        j /= 10;
                    }
                    j++;
                }
            }
            return ans;
        }
    }
}
