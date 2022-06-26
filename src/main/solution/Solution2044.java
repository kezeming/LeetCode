package main.solution;

class Solution2044 {
	int[] nums;
	int maxVal;
	int cnt;

	public int problem(int[] nums) {
		this.nums = nums;
		this.maxVal = 0;
		this.cnt = 0;
		dfs(0, 0);
		return cnt;
	}

	public void dfs(int pos, int val) {
		if(pos == nums.length) {
			if(val > maxVal) {
				maxVal = val;
				cnt = 1;
			} else if(val == maxVal) {
				cnt++;
			}
			return ;
		}
		dfs(pos+1, val | nums[pos]);
		dfs(pos+1, val);
	}
}