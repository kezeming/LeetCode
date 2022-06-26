package main.solution;

import java.util.*;

public class LeetCode_139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<i;j++) {
				if(dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}