package main.solution;
//「单调栈 + 贪心」：单调栈真的很常用很常用，一定要掌握

public class Solution316 {
	public String removeDuplicateLetters(String s) {
		boolean[] vis = new boolean[26];
		int[] num = new int[26];
		for(int i=0;i<s.length();i++) {
			num[s.charAt(i)-'a']++;
		}

		StringBuffer sb = new StringBuffer();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(!vis[ch-'a']) {
				while(sb.length() > 0 && sb.charAt(sb.length()-1) > ch) {
					if(num[sb.charAt(sb.length()-1)-'a'] > 0) {
						vis[sb.charAt(sb.length()-1)-'a'] = false;
						sb.deleteCharAt(sb.length()-1);
					} else {
						break;
					}
				}
				vis[ch-'a'] = true;
				sb.append(ch);
			}
			num[ch - 'a']--;
		}
		return sb.toString();
	}
}