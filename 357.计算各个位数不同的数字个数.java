/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 *
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/description/
 *
 * algorithms
 * Medium (50.74%)
 * Likes:    60
 * Dislikes: 0
 * Total Accepted:    9.5K
 * Total Submissions: 18.8K
 * Testcase Example:  '2'
 *
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n 。
 * 
 * 示例:
 * 
 * 输入: 2
 * 输出: 91 
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n && i <= 10; i++) {
            int c = 9;
            for (int j = 0; j < i - 1; j++) {
                c *= 9 - j;
            }
            dp[i] = c + dp[i - 1];
        }

        return n <= 10 ? dp[n] : dp[10];
    }
}
// @lc code=end

