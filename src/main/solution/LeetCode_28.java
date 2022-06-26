package main.solution;

public class LeetCode_28 {
    public int strStr(String s, String p) {
        int n = s.length(), m = p.length();
        if (m == 0)
            return 0;

        s = " " + s;
        p = " " + p;

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && pp[i] != pp[j + 1]) {
                j = next[j];
            }
            if (pp[i] == pp[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && ss[i] != pp[j + 1]) {
                j = next[j];
            }
            if (ss[i] == pp[j + 1]) {
                j++;
            }
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }
}