package main.solution;
//「线段树」
//线段树可以分为以下三个步骤：
//1.从给定数组构建线段树的预处理步骤
//2.修改元素时更新线段树
//3.使用线段树进行区域和检索
//
//1.数组不变，求区间和：「前缀和」
//2.数组单点修改，区间查询：「树状数组」
//3.数组区间修改，单点查询：「差分」
//4.数组区间修改，区间查询：「线段树」
//
//「树状数组」

class Solution307 {
	int[] tree;
	/**
	 	x&(-x)：保留二进制下最后出现的1的位置，其余位置置0
		x&(x-1)：消除二进制下最后出现1的位置，其余保持不变 
	**/
	int lowbit(int x) {
		return x & -x;
	}
	int query(int x) {
		int ans = 0;
		for(int i=x;i>0;i-=lowbit(i))
			ans += tree[i];
		return ans;
	}
	void add(int x, int u) {
		for(int i=x;i<=n;i+=lowbit(i))
			tree[i] += u;
	}

	int[] nums;
	int n;
	public Solution307(int[] nums) {
		this.nums = nums;
		n = nums.length;
		tree = new int[n+1];
		for(int i=0;i<n;i++) {
			add(i+1, nums[i]);
		}
	}

	public void update(int i, int val) {
		add(i+1, val-nums[i]);
		nums[i] = val;
	}

	public int sumRange(int l, int r) {
		return query(r+1) - query(l);
	}
}

//「树状数组模板」
// 上来先把三个方法写出来
//{
//	int[] tree;
//	int lowbit(int x) {
//		return x & -x;
//	}
//	// 查询前缀和的方法
//	int query(int x) {
//		int ans = 0;
//		for(int i=x;i>0;i-=lowbit(i))
//			ans += tree[i];
//		return ans;
//	}
//	// 在树状数组x位置中增加值u
//	void add(int x, int u) {
//		for(int i=x;i<=n;i+=lowbit(i))
//			tree[i] += u;
//	}
//}
//// 初始化「树状数组」，默认数组是从1开始
//{
//	for(int i=0;i<n;i++) {
//		add(i+1, nums[i]);
//	}
//}
//// 使用「树状数组」
//{
//	void update(int i, int val) {
//		// 原有值是nums[i]，要使得修改为val，需要增加val-nums[i]
//		add(i+1, val-nums[i]);
//		nums[i] = val;
//	}
//	int sumRange(int l, int r) {
//		return query(r+1) - query(l);
//	}
//}