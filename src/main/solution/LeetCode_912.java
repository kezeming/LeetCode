/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/4/12 22:39
 */
public class LeetCode_912 {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 3, 7, 6, 8, 0, 5 };
        sortArray(arr);
    }
    public static void sortArray(int[] nums) {
        QuickSort(nums, 0, nums.length-1);
    }

    @Deprecated
    public void quickSort(int[] p, int l, int r) {
        if(l >= r) return;
        int i = l-1, j = r+1, x=p[i+j>>1];
        while(i < j) {
            while (p[++i] < x);
            while (p[--j] > x);
            if(i < j) {
                int tmp = p[i];
                p[i] = p[j];
                p[j] = tmp;
            }
        }
        quickSort(p, l, j);
        quickSort(p, j+1, r);
    }

    // 找数组中第K大的元素or第K小的元素，都可以使用快排
    // 注意传入的K值
    @Deprecated
    public static void quickSort(int[] p, int l, int r, int k) {
        if(l >= r) return;
        int i = l-1, j = r+1, x = p[i+j>>1];
        while (i < j) {
            while (p[++i] < x);
            while (p[--j] > x);
            if (i < j) {
                int tmp = p[i];
                p[i] = p[j];
                p[j] = tmp;
            }
        }
        if(k <= j) {
            quickSort(p, l, j, k);
        } else {
            quickSort(p, j+1, r, k);
        }
    }

    // 快排实现方式 V2
    public static void QuickSort(int[] a, int l, int r) {
        if(l < r) {
            int p = partition(a, l, r);
            QuickSort(a, l, p-1);
            QuickSort(a, p+1, r);
        }
    }

    // 随机快排
    static Random random = new Random();

    public static void RandomQuickSort(int[] a, int l, int r) {
        if(l < r) {
            int p = randomPartition(a, l, r);
            RandomQuickSort(a, l, p-1);
            RandomQuickSort(a, p+1, r);
        }
    }

    public static int randomPartition(int[] a, int l, int r) {
        int p = random.nextInt(r - l) + l;
        swap(a, p, r);
        return partition(a, l, r);
    }

    public static int partition(int[] a, int l, int r) {
        int p = l-1;
        int x = a[r];
        for(int i=l;i<r;i++) {
            if(a[i] <= x) {
                swap(a, i, ++p);
            }
        }
        swap(a, r, p+1);
        return p+1;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
