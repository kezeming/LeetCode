package main.solution;

import java.util.*;

public class LeetCode_556 {
    public int nextGreaterElement(int n) {
        List<Integer> nums = new ArrayList<>();
        int nn = n;
        while (n != 0) {
            nums.add(n%10);
            n /= 10;
        }
        Collections.reverse(nums);
        int i = nums.size() - 2;
        while(i>=0 && nums.get(i) >= nums.get(i+1)) {
            i--;
        }
        if(i >= 0) {
            int j = nums.size() - 1;
            while (j>i && nums.get(i) >= nums.get(j)) {
                j--;
            }
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
        reverse(nums, i+1, nums.size()-1);
        int ret = 0;
        for (Integer num : nums) {
            ret = ret * 10 + num;
        }
        if(ret < nn) {
            return -1;
        }
        return ret;
    }
    public void reverse(List<Integer> list, int l, int r) {
        while (l < r) {
            int tmp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, tmp);
            l++;
            r--;
        }
    }
}
