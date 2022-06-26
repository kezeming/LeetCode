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
 * @create 2022/6/7 22:28
 */
public class LeetCode_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while(left < right) {
            int speed = (left + right) >> 1;
            long cnt = 0;
            for(int i=0;i<n;i++) {
                cnt += (piles[i] + speed - 1) / speed;
            }
            if(cnt <= h) {
                right = speed;
            } else {
                left = speed + 1;
            }
        }
        return left;
    }
}
