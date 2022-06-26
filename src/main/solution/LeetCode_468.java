/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.solution;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/6/1 14:41
 */
public class LeetCode_468 {
    public String validIPAddress(String queryIP) {
        if(queryIP.contains(".")) {
            if(validIPv4(queryIP)) {
                return "IPv4";
            } else {
                return "Neither";
            }
        } else {
            if(validIPv6(queryIP)) {
                return "IPv6";
            } else {
                return "Neither";
            }
        }
    }

    public boolean validIPv4(String queryIP) {
        String[] ip = queryIP.split("\\.", -1);
        if(ip.length != 4) {
            return false;
        }
        for (String s : ip) {
            if (ip2Num(s) == -1) {
                return false;
            }
        }
        return true;
    }

    public int ip2Num(String ip) {
        if(ip.length() == 0 || ip.length() > 3 || (ip.charAt(0) == '0' && ip.length() > 1)) {
            return -1;
        }
        int ret = 0;
        for(int i=0;i<ip.length();i++) {
            char ch = ip.charAt(i);
            if(ch >= '0' && ch <= '9') {
                ret = ret * 10 + ch - '0';
            } else {
                return -1;
            }
        }
        if(ret > 255) {
            return -1;
        }
        return ret;
    }

    public boolean validIPv6(String queryIP) {
        String[] ip = queryIP.split(":", -1);
        if(ip.length != 8) {
            return false;
        }
        for (String s : ip) {
            if(s.length() > 4 || s.length() == 0) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
