/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 *
 * https://leetcode-cn.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (32.93%)
 * Likes:    71
 * Dislikes: 0
 * Total Accepted:    7.8K
 * Total Submissions: 23K
 * Testcase Example:  '"3+2*2"'
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 
 * 示例 1:
 * 
 * 输入: "3+2*2"
 * 输出: 7
 * 
 * 
 * 示例 2:
 * 
 * 输入: " 3/2 "
 * 输出: 1
 * 
 * 示例 3:
 * 
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 
 * 
 * 说明：
 * 
 * 
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * 
 * 
 */

// @lc code=start
class Solution {
    int offset = 0;
    public int calculate(String s) {
        offset = 0;
        char[] chars = s.toCharArray();
        int result = 0;
        int sign = 1;
        for (; offset < chars.length; offset++) {
            char c = chars[offset];
            if (c >= '0' && c <= '9') {
                result += getValue(chars) * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            }
        }
        return result;
    }

    private int getValue(char[] chars) {
        int result = 0;
        char sign = '+';
        for (; offset < chars.length && chars[offset] != '+' && chars[offset] != '-'; offset++) {
            if (Character.isDigit(chars[offset])) {
                int cur = 0;
                while (offset < chars.length && Character.isDigit(chars[offset])) {
                    cur = cur * 10 + chars[offset] - '0';
                    offset++;
                }
                offset--;
                if (sign == '+') {
                    result += cur;
                } else if (sign == '*') {
                    result *= cur;
                } else {
                    result /= cur;
                }
            } else if (chars[offset] == ' ') {
                //do nothing
            } else {
                sign = chars[offset];
            }
        }
        offset--;
        return result;
    }
}
// @lc code=end

