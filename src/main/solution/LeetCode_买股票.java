package main.solution;

import java.util.Arrays;

public class LeetCode_买股票 {
	// 121 -- 简单 （<=1）
	static class Solution_121 {
		public int maxProfit(int[] prices) {
			int minprice = Integer.MAX_VALUE, ret = 0;
			int n = prices.length;
			for(int i=0;i<n;i++) {
				minprice = Math.min(minprice, prices[i]);
				ret = Math.max(ret, prices[i] - minprice);
			}
			return ret;
		}
	}


	// 122 -- 中等 （任意次数，买之前手里不能有股票）
	static class Solution_122 {
		public int maxProfit(int[] prices) {
			int ret = 0;
			int price = -prices[0];
			int n = prices.length;
			for(int i=1;i<n;i++) {
				ret += Math.max(0, prices[i] + price);
				price = -prices[i];
			}
			return ret;
		}
	}

	// 123 -- 困难 （<=2，买之前不能有股票）
	static class Solution_123 {
		public int maxProfit(int[] prices) {
			int n = prices.length;
			int buy1 = -prices[0], sell1 = 0;
			int buy2 = -prices[0], sell2 = 0;
			for(int i=1;i<n;i++) {
				buy1 = Math.max(buy1, -prices[i]); // 找最小的入手价格
				sell1 = Math.max(buy1 + prices[i], sell1);
				buy2 = Math.max(sell1 - prices[i], buy2);
				sell2 = Math.max(buy2 + prices[i], sell2);
			}
			return sell2;
		}
	}

	// 188 -- 困难 （<=k，买之前不能有股票）
	static class Solution_188 {
		public int maxProfit(int k, int[] prices) {
			int n = prices.length;
			if(k == 0 || n == 0)
				return 0;
			int[] buy = new int[k];
			int[] sell = new int[k];
			Arrays.fill(buy, -prices[0]);
			Arrays.fill(sell, 0);
			for(int i=1;i<n;i++) {
				buy[0] = Math.max(buy[0], -prices[i]);
				sell[0] = Math.max(buy[0] + prices[i], sell[0]);
				for(int j=1;j<k;j++) {
					buy[j] = Math.max(sell[j-1] - prices[i], buy[j]);
					sell[j] = Math.max(buy[j] + prices[i], sell[j]);
				}
			}
			return sell[k-1];
		}
	}
}