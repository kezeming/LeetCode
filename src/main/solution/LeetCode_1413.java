package main.solution;

public class LeetCode_1413 {
    public int minStartValue(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int sumVal = 0;
        for (int num : nums) {
            sumVal += num;
            minVal = Math.min(minVal, sumVal);
        }
        return minVal >= 1 ? 1 : 1 - minVal;
    }
}
