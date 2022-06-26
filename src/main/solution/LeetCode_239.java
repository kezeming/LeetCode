package main.solution;

import java.util.ArrayDeque;
import java.util.Deque;

// 对于「最大值」，我们可以想到一种非常合适的数据结构，即优先队列（堆）
// 其中「大根堆」可以帮助我们实时维护一系列元素中的最大值
public class LeetCode_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n-k+1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}