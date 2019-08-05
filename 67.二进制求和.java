/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (49.65%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    32.8K
 * Total Submissions: 66.1K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        StringBuilder result = new StringBuilder();
        char flag = '0';
        int max = Math.max(a.length(), b.length());
        a = lpad0(a, max);
        b = lpad0(b, max);
        for (int i = max - 1; i >= 0; i--) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            char r = '1';

            if (x == '1' && y == '1') {
                r = flag;
                flag = '1';
            } else if (x == '0' && y == '0') {
                r = flag;
                flag = '0';
            } else if (flag == '1') {
                r = '0';
            }

            result.insert(0, r);
        }
        if (flag == '1') {
            result.insert(0, flag);
        }
        return result.toString();
    }

    public String lpad0(String str, int count) {
        StringBuilder strBuilder = new StringBuilder(str);
        int rem = count - strBuilder.length();
        for (int i = 0; i < rem; i++) {
            strBuilder.insert(0, 0);
        }
        str = strBuilder.toString();
        return str;
    }
}

