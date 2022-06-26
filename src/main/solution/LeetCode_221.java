package main.solution;

public class LeetCode_221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSize = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = (matrix[i][j]=='1') ? 1 : 0;
                } else {
                    if(matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        return maxSize * maxSize;
    }
}