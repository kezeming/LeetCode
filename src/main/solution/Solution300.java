package main.solution;

//最长递增子序列
//经典DP动态规划问题！！！
//定义dp[i]为考虑前i个元素，以第i个数字结尾的最长上升子序列的长度，注意nums[i]必须被选取

/**
 * Created by IntelliJ IDEA.
 * @Author : KZM
 * @create 2022/4/9 21:51
 */
public class Solution300 {
	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int ret = 1;
		for(int i=1;i<nums.length;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ret = Math.max(dp[i], ret);
		}
		return ret;
	}
}