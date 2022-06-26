package main.solution;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_128 {
	public int longestConsecutive(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
		for(int num : nums) {
			num_set.add(num);
		}

		int longestCnt = 0;
		for(int num : nums) {
			if(!num_set.contains(num-1)) {
				int currNum = num;
				int currCnt = 1;
				while(num_set.contains(currNum+1)) {
					currNum++;
					currCnt++;
				}

				longestCnt = Math.max(currCnt, longestCnt);
			}
		}
		return longestCnt;
	}
}