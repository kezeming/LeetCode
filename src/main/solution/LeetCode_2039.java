package main.solution;

import java.util.*;

public class LeetCode_2039 {
    List<Integer>[] ret;
    Map<Integer, List<Integer>> mp;
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        ret = new List[n];
        mp = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            if(!mp.containsKey(from)) {
                mp.put(from, new ArrayList<Integer>());
            }
            if(!mp.containsKey(to)) {
                mp.put(to, new ArrayList<Integer>());
            }
            mp.get(from).add(to);
            mp.get(to).add(from);
        }
//        for(Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
//            int key = entry.getKey();
//            List<Integer> val = entry.getValue();
//            System.out.println(key + "=" + val);
//        }
        boolean[] vis = new boolean[n];
        for (int i = 1; i < n; i++) {
            dfs(new ArrayList<Integer>(), vis, 0, i);
        }
        for (int i = 1; i < n; i++) {
            Collections.reverse(ret[i]);
        }
        for(int i=1;i<n;i++) {
            System.out.println(ret[i]);
        }
        // ------------------------
        int MaxTime = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int minTime = ret[i].size()*2-2;
            if(minTime > patience[i]) {
                int extraTime = minTime % patience[i];
                minTime = 2*minTime - extraTime;
            }
            MaxTime = Math.max(MaxTime, minTime);
        }
        return MaxTime;
    }

    public void dfs(List<Integer> path, boolean[] vis, int start, int end) {
        if(start == end) {
            if(ret[end] == null) {
                ret[end] = new ArrayList<>(path);
            } else if(path.size() < ret[end].size()) {
                ret[end].clear();
                ret[end] = new ArrayList<>(path);
            }
        }
        for(int next : mp.get(start)) {
            if(!vis[next]) {
                vis[next] = true;
                path.add(next);
                dfs(path, vis, next, end);
                path.remove(path.size()-1);
                vis[next] = false;
            }
        }
    }
}

