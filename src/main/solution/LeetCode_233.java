package main.solution;

// 数学题
public class LeetCode_233 {
	public int countDigitOne(int n) {
		// mulk 表示 10^k
		// 在下面的代码中，可以发现k并没有被直接使用到（都是使用10^k）
		// 但为了让代码看起来更加直观，这里保留了k
		long mulk = 1;
		int ans = 0;
		for(int k=0;n>=mulk;k++) {
			ans += (n/(mulk*10))*mulk + Math.min(Math.max(n%(mulk*10)-mulk+1, 0), mulk);
			mulk *= 10;
		}
		return ans;
	}
}