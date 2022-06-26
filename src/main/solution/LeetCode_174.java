package main.solution;

import java.util.Arrays;

public class LeetCode_174 {
    public int calculateMinimumHP(int[][] dungeon) {
    	int m = dungeon.length;
    	int n = dungeon[0].length;
    	int[][] dp = new int[n+1][m+1];
    	for(int i=0;i<=n;i++) {
    		Arrays.fill(dp[i], Integer.MAX_VALUE);
    	}
    	dp[m][n-1] = dp[m-1][n] = 1;
    	for(int i=m-1;i>=0;i--) {
    		for(int j=n-1;j>=0;j--) {
    			int minn = Math.min(dp[i+1][j], dp[i][j+1]);
    			dp[i][j] = Math.max(minn - dungeon[i][j], 1);
    		}
    	}
    	return dp[0][0];
    }
}