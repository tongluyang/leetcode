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
        Stack<Integer> stack = new Stack<>();
        boolean push = true;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    push = true;
                    break;
                case ' ':
                    break;
                case '+':
                    stack.push(1);
                    break;
                case '-':
                    stack.push(-1);
                    break;
                case ')':
                    cur = stack.pop();
                    if (!stack.isEmpty()) {
                        cur = cur * stack.pop() + stack.pop();
                    }
                    stack.push(cur);
                    break;
                default:
                    StringBuilder curStr = new StringBuilder();
                    while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                        curStr.append(chars[i]);
                        i++;
                    }
                    i--;//多走了一步
                    cur = Integer.parseInt(curStr.toString());
                    if (push) {
                        push = false;
                    } else {
                        cur = cur * stack.pop() + stack.pop();
                    }
                    stack.push(cur);
            }
        }
        return stack.pop();
    }
}
// @lc code=end

