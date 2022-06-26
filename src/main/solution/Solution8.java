/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/4/10 15:22
 */
public class Solution8 {
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            automaton.get(s.charAt(i));
        }
        return (int)(automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> trans = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = trans.get(state)[getIdx(c)];
        if("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
        } else if("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    public int getIdx(char c) {
        if(c == ' ') {
            return 0;
        } else if(c == '+' || c == '-') {
            return 1;
        } else if(Character.isDigit(c)) {
            return 2;
        } else {
            return 3;
        }
    }
}
