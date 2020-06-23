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
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        char flag = '0';
        while (i >= 0 || j >= 0) {
            char ca = i < 0 ? '0' : a.charAt(i);
            char cb = j < 0 ? '0' : b.charAt(j);
            if (ca == '0' && cb == '0') {
                res.insert(0, flag);
                flag = '0';
            } else if (ca == '1' && cb == '1') {
                res.insert(0, flag);
                flag = '1';
            } else {
                if (flag == '0') {
                    res.insert(0, '1');
                } else {
                    res.insert(0, '0');
                    flag = '1';
                }
            }
            i--;
            j--;
        }
        if (flag == '1') {
            res.insert(0, flag);
        }
        return res.toString();
    }
}

