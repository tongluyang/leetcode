/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 *
 * https://leetcode-cn.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (33.29%)
 * Likes:    110
 * Dislikes: 0
 * Total Accepted:    7.3K
 * Total Submissions: 20.4K
 * Testcase Example:  '"1 + 1"'
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * 
 * 示例 1:
 * 
 * 输入: "1 + 1"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 
 * 示例 3:
 * 
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
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
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();//括号外
        int sign = 1;//实际
        stack.push(1);
        int cur = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    stack.push(sign);
                    break;
                case ' ':
                    break;
                case '+':
                    sign = stack.peek();
                    break;
                case '-':
                    sign = -1 * stack.peek();
                    break;
                case ')':
                    stack.pop();
                    break;
                default:
                    cur = 0;
                    while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                        cur = cur * 10 + chars[i] - '0';
                        i++;
                    }
                    i--;//多走了一步
                    result += cur * sign;
            }
        }
        return result;
    }
}
// @lc code=end

