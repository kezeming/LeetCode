package main.solution;// 只出现一次的数字（出现三次和出现一次）
// 数字门电路优化解法

public class Solution137 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}