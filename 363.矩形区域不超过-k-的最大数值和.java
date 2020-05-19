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
        int max = Integer.MIN_VALUE;
        int[][] sum = new int[row][col + 1];
        for (int c1 = 0; c1 < col; c1++) {
            for (int c2 = c1; c2 < col; c2++) {
                int colMax = Integer.MIN_VALUE;
                int[] colSum = new int[row];
                for (int i = 0; i < row; i++) {
                    if (c1 == 0) {
                        sum[i][c2 + 1] = sum[i][c2] + matrix[i][c2];
                    }

                    int s = sum[i][c2 + 1] - sum[i][c1];
                    colMax = Math.max(colMax + s, s);
                    if (colMax == k) {
                        return k;
                    }
                    colSum[i] = s;
                }
                if (colMax < k && colMax > max) {
                    max = colMax;
                }
                for (int l = 0; l < colSum.length; l++) {
                    int s = 0;
                    for (int r = l; r < colSum.length; r++) {
                        s += colSum[r];
                        if (s > max && s <= k) {
                            max = s;
                        }
                        if (max == k) {
                            return k;
                        }
                    }
                }
            }
        }
        return max;
    }
}
// @lc code=end

