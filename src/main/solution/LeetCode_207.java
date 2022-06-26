package main.solution;// 拓扑排序

import java.util.*;

public class LeetCode_207 {
	List<List<Integer>> edges;
	int[] vis;
	boolean valid = true;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
		vis = new int[numCourses];
		for(int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}
		for(int i=0;i<numCourses&&valid;i++) {
			if(vis[i] == 0) {
				dfs(i);
			}
		}
		return valid;
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
	}
}