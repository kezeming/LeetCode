package main.solution;

import java.util.HashSet;
import java.util.*;

public class LeetCode_565 {
    public int arrayNesting(int[] nums) {
        int ret = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while(nums[i] < n) {
                int num = nums[i];
                nums[i] = n;
                i = num;
                cnt++;
            }
            ret = Math.max(ret, cnt);
        }
        return ret;
    }
}
