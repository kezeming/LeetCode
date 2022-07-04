package main.solution;

import java.util.*;

public class LeetCode_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1] - arr[i] < gap) {
                gap = arr[i+1] - arr[i];
                res.clear();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i]);
                tmp.add(arr[i+1]);
                res.add(tmp);
            } else if(arr[i+1] - arr[i] == gap){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i]);
                tmp.add(arr[i+1]);
                res.add(tmp);
            }
        }
        return res;
    }
}
