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
 * @create 2022/4/22 10:10
 */
public class LeetCode_396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length, sumNum = Arrays.stream(nums).sum();
        int f = 0;
        for (int i = 0; i < n; i++) {
            f += i*nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += sumNum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }
}
