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
        int i = 0;
        for (int j = i + 1; j <= num.length() - 2; j++) {
            for (int k = j + 1; k <= num.length() - 1; k++) {
                if (isAdditiveNumber(num, i, j, k)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String num, int i, int j, int k) {
        if (i > 0 && k == num.length()) {
            return true;
        }
        if (num.charAt(j) == '0' && k - j > 1) { //0开头且不为0的数
            return false;
        }
        int flag = 0;
        int maxLen = Math.max(j - i, k - j);
        StringBuilder sum = new StringBuilder();
        for (int x = 1; x <= maxLen; x++) {
            int n1 = j - x < i ? 0 : num.charAt(j - x) - '0';
            int n2 = k - x < j ? 0 : num.charAt(k - x) - '0';
            sum.insert(0, (n1 + n2 + flag) % 10);
            flag = (n1 + n2 + flag) / 10;
        }
        if (flag != 0) {
            sum.insert(0, 1);
        }

        if (k + sum.length() <= num.length() && sum.toString().equals(num.substring(k, k + sum.length()))) {
            return isAdditiveNumber(num, j, k, k + sum.length());
        }
        return false;
    }
}
// @lc code=end

