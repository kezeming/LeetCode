package main.java;

import main.resources.TreeNode;
import main.solution.Solution110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeNode root = null;
        List<Integer> lists = new ArrayList<>();
        while(!in.hasNext("#")) {
            lists.add(in.nextInt());
        }
        root = root.buildTree(lists, 1);

        Solution110 solution110 = new Solution110();
        System.out.println(solution110.height(root));;
    }
}
