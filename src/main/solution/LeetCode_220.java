package main.solution;

import java.util.*;

// 桶排序
class LeetCode_220 {
	long size;
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int n = nums.length;
		Map<Long, Long> map = new HashMap<>();
		size = t + 1L;
		for(int i=0;i<n;i++) {
			long u = nums[i]*1L;
			long idx = getIdx(u);
			// 目标桶已存在（桶不为空），说明前面已有 [u-t, u+t] 范围的数字
			if(map.containsKey(idx))
				return true;
			long l = idx - 1, r = idx + 1;
			if(map.containsKey(l) && u-map.get(l) <= t)
				return true;
			if(map.containsKey(r) && map.get(r)-u <= t)
				return true;
			// 建立目标桶
			map.put(idx, u);
			// 移除下标范围不在 [max(0, i-k), i] 的桶
			if(i >= k)
				map.remove(getIdx(nums[i-k]*1L));
		}
		return false;
	}
	long getIdx(long u) {
		return u >= 0 ? u / size : ((u+1)/size)-1;
	}
}