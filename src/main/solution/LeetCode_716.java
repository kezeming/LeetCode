package main.solution;

import java.util.*;

//「只用一个栈来实现最大栈」
public class LeetCode_716 {
    class MaxStack {
        Deque<Long> stack;
        long maxVal;

        public MaxStack() {
            stack = new ArrayDeque<Long>();
            maxVal = Long.MIN_VALUE;
        }

        public void push(int val) {
            if(stack.isEmpty()) {
                stack.offerLast(0L);
                maxVal = (long)val;
            } else {
                long value = (long)val;
                stack.offerLast(val - maxVal);
                maxVal = Math.max(maxVal, value);
            }
        }

        public void pop() {
            if(stack.peekLast() > 0) {
                maxVal -= stack.peekLast();
            }
            stack.pollLast();
        }

        public int top() {
            if(stack.isEmpty()) {
                return -1;
            }
            if(stack.peekLast() > 0) {
                return (int)maxVal;
            } else {
                return (int)(stack.peekLast()+maxVal);
            }
        }

        public int getMax() {
            return (int)maxVal;
        }
    }
}