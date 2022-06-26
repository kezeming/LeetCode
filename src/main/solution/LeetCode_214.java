/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/5/7 23:34
 */
public class LeetCode_214 {
    public String shortestPalindrome(String s) {
        StringBuffer p = new StringBuffer(s);
        int best = kmp(p.reverse().toString(), s);
        if(best != s.length()) {
            best = kmp(p.substring(p.length()-best, p.length()), s.substring(0, best));
        }
        String add = (best == s.length()-1 ? "" : s.substring(best+1));
        StringBuffer ans = new StringBuffer(add).reverse().append(s);
        return ans.toString();
    }

    public int kmp(String s, String p) {
        int n = s.length(), m = p.length();

        s = " " + s;
        p = " " + p;

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        int[] next = new int[m+1];

        for(int i=2,j=0;i<=m;i++) {
            while (j>0 && pp[i] != pp[j+1]) {
                j = next[j];
            }
            if(pp[i] == pp[j+1]) {
                j++;
            }
            next[i] = j;
        }
        int maxLen = 0;
        for(int i=2,j=0;i<=n;i++) {
            while (j>0 && ss[i] != pp[j+1]) {
                j = next[j];
            }
            if(ss[i] == pp[j+1]) {
                j++;
            }
            maxLen = Math.max(maxLen, j);
        }
        return maxLen;
    }
}
