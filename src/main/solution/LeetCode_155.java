package main.solution;
//「只用一个栈来实现最小栈」

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_155 {
	static class MinStack {
		Deque<Long> stack;
		long min;

		public MinStack() {
			stack = new ArrayDeque<>();
			min = Long.MAX_VALUE;
		}

		public void push(int val) {
			long value = (long)val;
			if(stack.isEmpty()) {
				stack.offerLast(0L);
				min = value;
			} else {
				stack.offerLast(value - min);
				if(value < min) {
					min = value;
				}
			}
		}
		public void pop() {
			if(!stack.isEmpty()) {
				long dec = stack.pollLast();
				if(dec < 0) {
					min = min - dec;
				}
			}
		}
		public int top() {
			if(stack.isEmpty()) {
				return -1;
			}
			if(stack.peekLast() < 0) {
				return (int)min;
			} else {
				return (int)(stack.peekLast()+min);
			}
		}
		public int getMin() {
			if(stack.isEmpty()) {
				return -1;
			}
			return (int)min;
		}
	}

}