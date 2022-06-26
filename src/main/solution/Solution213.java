package main.solution;// 情况推理 分类讨论
//只有一间房屋，偷窃
//只有两间房屋，取较大者偷窃
//超过两间房屋，需要考虑首尾相连情况；
//	若偷第一家，则不能偷最后一家，则偷窃范围为[0, n-1]；
//	若偷最后一家，则不能偷第一家，则偷窃范围为[1, n]；
//确定完偷窃范围后，即可用普通的DP来解决问题
//状态转移方程为 dp[i] = max(dp[i-2] + nums[i], dp[i-1])
//边界条件为只有一间和两间房屋的情况。
//
//// 空间优化
//考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组
//每个时刻只需要存储前两间房屋的最高金额，空间复杂度降为O(1)

public class Solution213 {
	public int rob(int[] nums) {
		int length = nums.length;
		if(length == 1) {
			return nums[0];
		} else if(length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(robRange(nums, 0, length-2), robRange(nums, 1, length-1));
	}

	public int robRange(int[] nums, int s, int e) {
		int first = nums[s], second = Math.max(nums[s], nums[s+1]);
		for(int i=s+2;i<=e;i++) {
			int tmp = second;
			second = Math.max(first+nums[i], second);
			first = tmp;
		}
		return second;
	}
}