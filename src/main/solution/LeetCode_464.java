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
 * @create 2022/5/22 13:47
 */
public class LeetCode_464 {
    Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();

    public boolean canWin(int maxChoosableInteger, int desiredTotal) {
        if((1 + maxChoosableInteger) * (maxChoosableInteger >> 1) < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if(!memo.containsKey(usedNumbers)) {
            boolean res = false;
            for(int i=0;i<maxChoosableInteger;i++) {
                if(((usedNumbers >> i) & 1) == 0) {
                    if(i+1+currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    if(!dfs(maxChoosableInteger, usedNumbers | (1<<i), desiredTotal, currentTotal+i+1)) {
                        res = true;
                        break;
                    }
                }
            }
            memo.put(usedNumbers, res);
        }
        return memo.get(usedNumbers);
    }
}
