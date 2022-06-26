/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/5/7 15:13
 * @Method : 双向BFS
 */
public class LeetCode_127 {
    Set<String> dict;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) {
            return 0;
        }
        int t = bfs(beginWord, endWord);
        return t == -1 ? t : t+1;
    }

    public int bfs(String beginWord, String endWord) {
        // d1 : beginWord -> endWord
        // d2 : endWord -> beginWord
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();

        // step1 : beginWord -> endWord
        // step2 : endWord -> beginWord
        Map<String, Integer> step1 = new HashMap<>(), step2 = new HashMap<>();

        d1.offerLast(beginWord);
        step1.put(beginWord, 0);
        d2.offerLast(endWord);
        step2.put(endWord, 0);

        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if(d1.size() <= d2.size()) {
                t = update(d1, step1, step2);
            } else {
                t = update(d2, step2, step1);
            }
            if(t != -1) {
                return t;
            }
        }
        return -1;
    }

    public int update(Deque<String> queue, Map<String, Integer> step1, Map<String, Integer> step2) {
        int size = queue.size();
        for(int i=0;i<size;i++) {
            String currWord = queue.pollFirst();
            char[] charArray = currWord.toCharArray();
            for(int j=0;j<charArray.length;j++) {
                char origin = charArray[j];
                for(char ch='a';ch<='z';ch++) {
                    charArray[j] = ch;
                    String nextWord = String.valueOf(charArray);
                    if(!dict.contains(nextWord)) {
                        continue;
                    }
                    if(step1.containsKey(nextWord) && step1.get(nextWord) <= step1.get(currWord)+1) {
                        continue;
                    }
                    if(step2.containsKey(nextWord)) {
                        return step1.get(currWord) + 1 + step2.get(nextWord);
                    } else {
                        queue.offerLast(nextWord);
                        step1.put(nextWord, step1.get(currWord)+1);
                    }
                }
                charArray[j] = origin;
            }
        }
        return -1;
    }
}
