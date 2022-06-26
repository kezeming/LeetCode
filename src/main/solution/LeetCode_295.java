package main.solution;

import java.util.PriorityQueue;

public class LeetCode_295 {
	class MedianFinder {
		PriorityQueue<Integer> queMin;
		PriorityQueue<Integer> queMax;

		public MedianFinder() {
			queMin = new PriorityQueue<Integer>((a, b) -> (b - a)); // 大根堆
			queMax = new PriorityQueue<Integer>((a, b) -> (a - b)); // 小根堆
		}

		public void addNum(int num) {
			if(queMin.isEmpty() || num <= queMin.peek()) {
				queMin.offer(num);
				if(queMax.size() + 1 < queMin.size()) {
					queMax.offer(queMin.poll());
				}
			} else {
				queMax.offer(num);
				if(queMax.size() > queMin.size()) {
					queMin.offer(queMax.poll());
				}
			}
		}

		public double findMedian() {
			if(queMin.size() > queMax.size()) {
				return queMin.peek();
			}
			return (queMin.peek() + queMax.peek()) / 2.0;
		}
	}
}