/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 *
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (40.09%)
 * Likes:    150
 * Dislikes: 0
 * Total Accepted:    11.7K
 * Total Submissions: 29.2K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * 
 * 示例 1:
 * 
 * 输入: nums = 
 * [
 * ⁠ [9,9,4],
 * ⁠ [6,6,8],
 * ⁠ [2,1,1]
 * ] 
 * 输出: 4 
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 
 * 示例 2:
 * 
 * 输入: nums = 
 * [
 * ⁠ [3,4,5],
 * ⁠ [3,2,6],
 * ⁠ [2,2,1]
 * ] 
 * 输出: 4 
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return 0;
        }
        int res = 0;
        int[][] mem = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, longest(matrix, i, j, mem, Integer.MIN_VALUE));
            }
        }
        return res;
    }

    private int longest(int[][] matrix, int i, int j, int[][] mem, int pre) {
        if (i < 0 || j < 0 || i >= matrix.length ||  j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] <= pre) {
            return 0;
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int val = matrix[i][j];
        int u = longest(matrix, i - 1, j, mem, val);
        int d = longest(matrix, i + 1, j, mem, val);
        int l = longest(matrix, i, j - 1, mem, val);
        int r = longest(matrix, i, j + 1, mem, val);

        int longest = Math.max(
                Math.max(u, d),
                Math.max(l, r)
        ) + 1;

        mem[i][j] = longest;
        return longest;
    }
}
// @lc code=end

