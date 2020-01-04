/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode-cn.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (50.79%)
 * Likes:    269
 * Dislikes: 0
 * Total Accepted:    30.4K
 * Total Submissions: 58.3K
 * Testcase Example:  '12'
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 
 * 示例 1:
 * 
 * 输入: n = 12
 * 输出: 3 
 * 解释: 12 = 4 + 4 + 4.
 * 
 * 示例 2:
 * 
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        return numSquares(n, new HashMap<>());
    }

    private int numSquares(int n, Map<Integer, Integer> mem) {
        if (n == 0) {
            return 0;
        }
        if (mem.get(n) != null) {
            return mem.get(n);
        }
        final int s = new Double(Math.floor(Math.sqrt(n))).intValue();
        int min = Integer.MAX_VALUE;
        for (int i = s; i > 0; i--) {
            int rem = n - i * i;
            final int num = numSquares(rem, mem);
            mem.put(rem, num);
            min = Math.min(min, num + 1);
            if (min == 1) {
                return min;
            }
        }
        return min;
    }
}
// @lc code=end

