package main.solution;

import java.util.*;

public class LeetCode_212 {
	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for(String word : words) {
			trie.insert(word);
		}

		Set<String> ans = new HashSet<String>();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				dfs(board, trie, i, j, ans);
			}
		}

		return new ArrayList<String>(ans);
	}

	public void dfs(char[][] board, Trie now, int i, int j, Set<String> ans) {
		if(!now.children.containsKey(board[i][j])) {
			return ;
		}
		char ch = board[i][j];
		now = now.children.get(ch);
		if(!"".equals(now.word)) {
			ans.add(now.word);
		}

		board[i][j] = '#';
		for(int[] dir : dirs) {
			int x = i + dir[0], y = j + dir[1];
			if(x>=0 && x<board.length && y>=0 && y<board[0].length) {
				dfs(board, now, x, y, ans);
			}
		}
		board[i][j] = ch;
	}

	class Trie {
		String word;
		Map<Character, Trie> children;
		boolean isEnd;

		public Trie() {
			this.word = "";
			this.children = new HashMap<Character, Trie>();
			this.isEnd = false;
		}

		public void insert(String word) {
			Trie cur = this;
			for(int i=0;i<word.length();i++) {
				char c = word.charAt(i);
				if(!cur.children.containsKey(c)) {
					cur.children.put(c, new Trie());
				}
				cur = cur.children.get(c);
			}
			cur.word = word;
		}
	}
}