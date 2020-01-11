/*
 * @lc app=leetcode.cn id=282 lang=java
 *
 * [282] 给表达式添加运算符
 *
 * https://leetcode-cn.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (30.15%)
 * Likes:    55
 * Dislikes: 0
 * Total Accepted:    1.5K
 * Total Submissions: 4.7K
 * Testcase Example:  '"123"\n6'
 *
 * 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 * 
 * 示例 1:
 * 
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"] 
 * 
 * 
 * 示例 2:
 * 
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * 
 * 示例 3:
 * 
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 * 
 * 示例 4:
 * 
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 * 
 * 
 * 示例 5:
 * 
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> addOperators(String num, int target) {
        final ArrayList<String> result = new ArrayList<>();
        addOperators(result, "", num.toCharArray(), 0, target, 0, '+');
        return result;
    }

    private void addOperators(List<String> result, String parent, char[] chars, int start, int target,
                              int init, char initOper) {
        int num = 0;
        for (int i = start; i < chars.length; i++) {
            num = num * 10 + chars[i] - '0';
            if (num < 0) { // 溢出
                break;
            }
            int value;
            if (initOper == '+') {
                value = num;
            } else if (initOper == '-') {
                value = -num;
            } else {
                value = init * num;
            }
            if (i == chars.length - 1) {
                if (target == value) {
                    result.add(parent + num);
                }
            }
            addOperators(result, parent + num + "+", chars, i + 1, target - value, 0, '+'); // +
            addOperators(result, parent + num + "-", chars, i + 1, target - value, 0, '-'); // -
            addOperators(result, parent + num + "*", chars, i + 1, target, value, '*'); // *
            if (num == 0) { // 0不和后面的数组合
                break;
            }
        }
    }
}
// @lc code=end

