package main.solution;

import java.util.*;

public class LeetCode_210 {
	// 存储有向图
	List<List<Integer>> edges;
	// 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
	int[] vis;
	// 用数组来模拟栈，下标n-1为栈底，0为栈顶
	int[] res;
	// 判断有向图中是否有环
	boolean valid = true;
	// 栈下标
	int index;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
		vis = new int[numCourses];
		res = new int[numCourses];
		index = numCourses - 1;
		for(int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}
		// 每次挑选一个未搜索的节点，开始dfs
		for(int i=0;i<numCourses&&valid;i++) {
			if(vis[i] == 0) {
				dfs(i);
			}
		}
		if(!valid) {
			return new int[0];
		}
		return res;
	}

	public void dfs(int u) {
		vis[u] = 1;
		for(int v : edges.get(u)) {
			if(vis[v] == 0) {
				dfs(v);
				if(!valid) {
					return ;
				}
			} else if(vis[v] == 1) {
				valid = false;
				return ;
			}
		}
		vis[u] = 2;
		res[index--] = u;
	}
}