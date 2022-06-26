package main.solution;

import java.util.*;

public class LeetCode_365 {
    public boolean canMeasureWater(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<Long>();
        while(!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int remain_x = state[0], remain_y = state[1];
            if (remain_x == z || remain_y == z || remain_y + remain_x == z) {
                return true;
            }
            stack.push(new int[]{x, remain_y});
            stack.push(new int[]{remain_x, y});
            stack.push(new int[]{0, remain_y});
            stack.push(new int[]{remain_x, 0});
            stack.push(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
            stack.push(new int[]{remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0]*1000001 + state[1];
    }
}