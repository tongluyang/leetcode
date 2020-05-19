/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 *
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 *
 * algorithms
 * Hard (35.50%)
 * Likes:    81
 * Dislikes: 0
 * Total Accepted:    3.1K
 * Total Submissions: 8.6K
 * Testcase Example:  '[[1,0,1],[0,-2,3]]\n2'
 *
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * 
 * 示例:
 * 
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2 
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 
 * 
 * 说明：
 * 
 * 
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row + 1][col + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i + 1][j + 1] = matrix[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
                // x = sum[i'][j']
                // sum[i + 1][j + 1] - sum[i'][j + 1] - sum[i + 1][j'] + x <= k
                // x要尽可能大，但又不能太大
                for (int i1 = 0; i1 <= i; i1++) {
                    for (int j1 = 0; j1 <= j; j1++) {
                        int area = sum[i + 1][j + 1] - sum[i1][j + 1] - sum[i + 1][j1] + sum[i1][j1];
                        if (area == k) {
                            return k;
                        } else if (area < k && area > max) {
                            max = area;
                        }
                    }
                }
            }
        }
        return max;
    }
}
// @lc code=end

