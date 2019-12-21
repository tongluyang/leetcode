/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (68.43%)
 * Likes:    96
 * Dislikes: 0
 * Total Accepted:    5.4K
 * Total Submissions: 7.7K
 * Testcase Example:  '"2-1-1"'
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及
 * * 。
 * 
 * 示例 1:
 * 
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * 示例 2:
 * 
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        final char[] chars = input.toCharArray();
        return diffWaysToCompute(chars, 0, chars.length - 1);
    }

    private List<Integer> diffWaysToCompute(char[] chars, int start, int end) {
        List<Integer> result = new ArrayList<>();
        int num = 0;
        boolean reduce = true;
        for (int i = start; i <= end; i++) {
            final char c = chars[i];
            if (c == '+' || c == '-' || c == '*') {
                reduce = false;
                List<Integer> lefts = diffWaysToCompute(chars, start, i - 1);
                List<Integer> rights = diffWaysToCompute(chars, i + 1, end);

                for (Integer left : lefts) {
                    for (Integer right : rights) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else {
                            result.add(left * right);
                        }
                    }
                }
            } else {
                num = num * 10 + c - '0';
            }
        }
        if (reduce) {
            result.add(num);
        }
        return result;
    }
}
// @lc code=end

