/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (27.27%)
 * Likes:    254
 * Dislikes: 0
 * Total Accepted:    12.9K
 * Total Submissions: 47.2K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i - len);
                len = 0;
            } else {
                if (stack.size() == 0) {
                    if (ans < len) {
                        ans = len;
                    }
                    len = 0;
                } else {
                    int j = stack.pop();
                    len = i - j + 1;
                    if (ans < len) {
                        ans = len;
                    }
                }
            }
        }
        if (ans < len) {
            ans = len;
        }
        return ans;
    }
}
