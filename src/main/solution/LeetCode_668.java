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
 * @create 2022/5/18 10:35
 */
public class LeetCode_668 {
    public int count(int m, int n, int mid) {
        int i = m, j = 1; // 左下角开始
        int cnt = 0;
        while(i >= 1 && j <= n) {
            if(i * j <= mid) {
                cnt += i;
                j++;
            }
            else {
                i--;
            }
        }
        return cnt;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m*n;
        while(left < right) {
            int mid = (left+right) >> 1 ;
            if(count(m, n, mid) < k)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
}
