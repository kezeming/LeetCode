/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/4/20 11:33
 */
public class LeetCode_397 {
    Map<Integer, Integer> mem = new HashMap<Integer, Integer>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!mem.containsKey(n)) {
            if (n % 2 == 0) {
                mem.put(n, 1 + integerReplacement(n / 2));
            } else {
                mem.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return mem.get(n);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for(int k=0;k<turnedOn;k++) {
            if(k > 4 || turnedOn-k > 6) {
                continue;
            } else {
                List<String> hour = Hour(k);
                List<String> minutes = Minutes(turnedOn-k);
                for (String s : hour) {
                    System.out.println("hour="+s);
                }
                for (String s : minutes) {
                    System.out.println("minutes="+s);
                }
                for(int i=0;i<hour.size();i++) {
                    for(int j=0;j<minutes.size();j++) {
                        String min = minutes.get(j);
                        if(Integer.valueOf(min) < 10) {
                            min = "0" + min;
                        }
                        ans.add(hour.get(i) + ":" + min);
                    }
                }
            }
        }
        return ans;
    }
    public List<String> Hour(int turnedOn) {
        boolean[] vis = new boolean[4];
        List<String> res = new ArrayList<String>();
        dfs(res, vis, turnedOn, 0, 0, 0);
        return res;
    }
    public List<String> Minutes(int turnedOn) {
        boolean[] vis = new boolean[6];
        List<String> res = new ArrayList<String>();
        dfs(res, vis, turnedOn, 0, 0, 0);
        return res;
    }

    public void dfs(List<String> res, boolean[] vis, int turnedOn, int cnt, int idx, int val) {
        if(cnt == turnedOn) {
            res.add(Integer.toString(val));
            return ;
        }
        for(int i=idx;i<vis.length-turnedOn+1;i++) {
            if(!vis[i]) {
                vis[i] = true;
                val += 1<<i;
                dfs(res, vis, turnedOn, cnt+1, i+1, val);
                val -= 1<<i;
                vis[i] = false;
            }
        }
    }
}
