/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (62.09%)
 * Likes:    241
 * Dislikes: 0
 * Total Accepted:    22.4K
 * Total Submissions: 36.1K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = 0;
                if (i == 0 && j == 0) {
                    // do nothing
                } else if (i == 0) {//第一行，只能从左边来
                    min = dp[j - 1];
                } else if (j == 0) {//第一列，只能从上边来
                    min = dp[j];
                } else {
                    min = Math.min(dp[j], dp[j - 1]);
                }
                dp[j] = min + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
