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
 * @create 2022/5/14 13:26
 */
public class LeetCode_691 {
    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        //用数组保存状态的min，减少重复计算
        int[] memo = new int[1 << m];
        //设置状态初始值
        Arrays.fill(memo, -1);
        //递归终点，所有target字符都给撞完了
        memo[0] = 0;
        //开始递归调用
        int res = dp(stickers, target, memo, (1 << m) - 1);
        //如果res 是m+则说明遇到了无法撞击完的情况 则返回-1
        return res <= m ? res : -1;
    }

    public int dp(String[] stickers, String target, int[] memo, int mask) {
        int m = target.length();
        if (memo[mask] < 0) {
            //res初始值
            int res = m + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                //记录当前sticker的状态位
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++;
                }
                //开始撞击
                for (int i = 0; i < target.length(); i++) {
                    //对应标记target位
                    char c = target.charAt(i);
                    //如果还有这个位则 判断条件1成立
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                        //如果cnt[c-'a']则表示还有这个字符
                        cnt[c - 'a']--;
                        //对应消耗了 target的哪一位。
                        left ^= 1 << i;
                    }
                }
                //如果没有发生撞击则直接下一个字符串
                if (left < mask) {
                    //如果发生了撞击，则根据当前结果，递归撞击下去，只当为0。
                    //（其中如果递归以后遇到无法撞击的结果则会反回m+1。
                    res = Math.min(res, dp(stickers, target, memo, left) + 1);
                }
            }
            //记录当前长度最小消耗量
            memo[mask] = res;
        }
        //返回当前位置的最小值
        return memo[mask];
    }
}
