package main.solution;

import java.util.*;

public class LeetCode_1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int[] ans = new int[arr.length];
        for (int a : sortedArr) {
            if (!myMap.containsKey(a)) {
                myMap.put(a, myMap.size() + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = myMap.get(arr[i]);
        }
        return ans;
    }
}