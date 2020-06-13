/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 *
 * https://leetcode-cn.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (28.98%)
 * Likes:    229
 * Dislikes: 0
 * Total Accepted:    18.7K
 * Total Submissions: 64.4K
 * Testcase Example:  '"1432219"\n3'
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 
 * 注意:
 * 
 * 
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 
 * 
 * 示例 1 :
 * 
 * 
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 
 * 
 * 示例 2 :
 * 
 * 
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 
 * 
 * 示例 3 :
 * 
 * 
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        return removeKdigits(num, k, 0);
    }

    private String removeKdigits(String num, int k, int start) {
        if (num.length() == 0) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        if (start < 0) {
            start = 0;
        }
        if (start == 0 && num.length() > 1 && num.charAt(1) == '0') {//开头是X0，相当于移除不止一位，肯定移除
            int i = 1;
            while (i < num.length() && num.charAt(i) == '0') {
                i++;
            }
            return removeKdigits(num.substring(i), k - 1, 0);
        }
        while (start < num.length() - 1) {
            if (num.charAt(start) > num.charAt(start + 1)) {//当前数比后一个数大，需要移除，被移除了，前一个数有可能比后一个数大了
                return removeKdigits(num.substring(0, start) + num.substring(start + 1), k - 1, start - 1);
            }
            start++;
        }
        return removeKdigits(num.substring(0, num.length() - 1), k - 1, num.length() - 2);//移除最后一位
    }
}
// @lc code=end

