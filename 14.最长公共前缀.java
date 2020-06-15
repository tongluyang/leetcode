/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.60%)
 * Likes:    582
 * Dislikes: 0
 * Total Accepted:    87.5K
 * Total Submissions: 259.6K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int len = 0;
        char cur = 0;
        boolean finish = false;
        while (!finish) {
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if (str.length() <= len) {
                    finish = true;
                    break;
                }
                if (cur == 0) {
                    cur = str.charAt(len);
                } else if (str.charAt(len) != cur) {
                    finish = true;
                    break;
                }
                if (i == strs.length - 1) {
                    cur = 0;
                    len++;
                }
            }
        }
        return strs[0].substring(0, len);
    }
}
