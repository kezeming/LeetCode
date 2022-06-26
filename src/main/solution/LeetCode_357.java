/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/4/11 10:20
 */
class LeetCode_357 {
    public int countNumbersWithUniqueDigits(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.size();
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else {
            int res = 10, cur = 9;
            for (int i = 0; i < n - 1; i++) {
                cur *= 9 - i;
                res += cur;
            }
            return res;
        }
    }
}
