/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/9/17 21:48
 */
public class LeetCode_1624 {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int ret = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!mp.containsKey(ch)) {
                mp.put(ch, i);
            } else {
                ret = Math.max(ret, i - mp.get(ch) - 1);
            }
        }
        return ret;
    }
}
