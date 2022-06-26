package main.solution;

import java.util.*;

public class Solution126 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		// 因为需要快速判断扩展出的单词是否在wordList里，因此需要将wordList存入哈希表，这里命名为「字典」
		Set<String> dict = new HashSet<>(wordList);
		// 特殊用例判断
		if(!dict.contains(endWord)) {
			return res;
		}

		dict.remove(beginWord);

		// 第一步：广度优先遍历建图
		// 记录扩展出的单词是在第几步扩展的时候得到的，key: 单词，value: 在广度优先遍历的第几层
		Map<String, Integer> steps = new HashMap<>();
		steps.put(beginWord, 0);
		// 记录了单词是从哪些单词扩展而来，key: 单词， value: 单词列表，这些单词可以变换到 key，它们是一对多的关系
		Map<String, List<String>> from = new HashMap<>();
		int step = 1;
		boolean found = false;
		int wordLen = beginWord.length();
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				String currWord = queue.poll();
				char[] charArray = currWord.toCharArray();
				// 将每一位替换成26个小写英文字母
				for(int j=0;j<wordLen;j++) {
					char origin = charArray[j];
					for(char c='a';c<='z';c++) {
						charArray[j] = c;
						String nextWord = String.valueOf(charArray);
						if(steps.containsKey(nextWord) && step==steps.get(nextWord)) {
							from.get(nextWord).add(currWord);
						}
						if(!dict.contains(nextWord)) {
							continue;
						}
						// 如果从一个单词拓展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从dict中删除
						dict.remove(nextWord);
						// 这一层拓展出的单词进入队列
						queue.offer(nextWord);

						// 记录nextWord从currWord而来
						from.putIfAbsent(nextWord, new ArrayList<>());
						from.get(nextWord).add(currWord);
						// 记录nextWord的step
						steps.put(nextWord, step);
						if(nextWord.equals(endWord)) {
							found = true;
						}
					}
					charArray[j] = origin;
				}
			}
			step++;
			if(found) {
				break;
			}
		}
		// 第2步: 深度优先遍历找到所有解，从endWord恢复到beginWord，所以每次尝试操作path列表的头部
		if(found) {
			Deque<String> path = new ArrayDeque<>();
			path.add(endWord);
			dfs(from, path, beginWord, endWord, res);
		}
		return res;
	}

	public void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
		if(cur.equals(beginWord)) {
			res.add(new ArrayList<>(path));
			return;
		}
		for(String pre : from.get(cur)) {
			path.addFirst(pre);
			dfs(from, path, beginWord, pre, res);
			path.removeFirst();
		}
	} 
}