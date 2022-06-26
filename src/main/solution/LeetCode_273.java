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
 * @create 2022/5/7 22:40
 */
public class LeetCode_273 {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        StringBuffer sb = new StringBuffer();
        for(int i=3, unit=1000000000;i>=0;i--, unit/=1000) {
            int currNum = num / unit;
            if(currNum != 0) {
                num -= currNum*unit;
                sb.append(toEnglish(currNum)).append(thousands[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public String toEnglish(int num) {
        StringBuffer sb = new StringBuffer();
        int hundred = num / 100;
        num %= 100;
        if(hundred != 0) {
            sb.append(singles[hundred]).append(" Hundred ");
        }
        int ten = num / 10;
        if(ten >= 2) {
            sb.append(tens[ten]).append(" ");
            num %= 10;
        }
        if(num > 0 && num < 10) {
            sb.append(singles[num]).append(" ");
        } else if(num >= 10) {
            sb.append(teens[num-10]).append(" ");
        }
        return sb.toString();
    }
}
