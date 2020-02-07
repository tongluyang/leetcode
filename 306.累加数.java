/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 *
 * https://leetcode-cn.com/problems/additive-number/description/
 *
 * algorithms
 * Medium (31.59%)
 * Likes:    49
 * Dislikes: 0
 * Total Accepted:    3.7K
 * Total Submissions: 11.7K
 * Testcase Example:  '"112358"'
 *
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * 
 * 示例 1:
 * 
 * 输入: "112358"
 * 输出: true 
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * 
 * 示例 2:
 * 
 * 输入: "199100199"
 * 输出: true 
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 * 
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        return isAdditiveNumber(num, 0, 1, 1);
    }

    private boolean isAdditiveNumber(String num, int start, int length1, int length2) {
        if (start > 0 && start + length1 + length2 == num.length()) {
            return true;
        }
        if (start > num.length() - 3 || length1 > num.length() / 2 || length2 > num.length() / 2) {
            return false;
        }
        int resultLength = check(num, start, length1, length2);
        if (resultLength > 0 && isAdditiveNumber(num, start + length1, length2, resultLength)) {
            return true;
        }
        if (start > 0) {
            return false;
        }
        if (isAdditiveNumber(num, start, length1, length2 + 1)) {
            return true;
        }
        return isAdditiveNumber(num, start, length1 + 1, length2);
    }

    private int check(String num, int start, int length1, int length2) {
        if (start + length1 + length2 >= num.length()) {
            return 0;
        }
        String numStr1 = num.substring(start, start + length1);
        if (numStr1.startsWith("0") && !numStr1.equals("0")) {
            return 0;
        }
        long num1 = Long.parseLong(numStr1);
        String numStr2 = num.substring(start + length1, start + length1 + length2);
        if (numStr2.startsWith("0") && !numStr2.equals("0")) {
            return 0;
        }
        long num2 = Long.parseLong(numStr2);

        if (num.indexOf((num1 + num2) + "", start + length1 + length2) == start + length1 + length2) {
            return ((num1 + num2) + "").length();
        }
        return 0;
    }
}
// @lc code=end

