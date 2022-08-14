package main.solution;

import java.util.Map;

public class LeetCode_1422 {
    public int maxScore(String s) {
        int n = s.length();
        int res = 0;
        if (s.charAt(0) == '0') {
            res++;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        int ans = res;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                res++;
            } else {
                res--;
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
