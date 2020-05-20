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
        int[] rowSums = new int[row];
        int[][] sum = new int[row][col + 1];
        //固定列边界
        for (int c1 = 0; c1 < col; c1++) {
            for (int c2 = c1; c2 < col; c2++) {
                // leetcode 53题，求最大和
                int colMax = Integer.MIN_VALUE;
                int colSum = 0;
                for (int i = 0; i < row; i++) {
                    if (c1 == 0) {//左边界为0时，随着右边界移动，足够求出每行的前缀和
                        sum[i][c2 + 1] = sum[i][c2] + matrix[i][c2];
                    }

                    //当前行边界内的和
                    int rowSum = sum[i][c2 + 1] - sum[i][c1];
                    if (colSum > 0) {
                        colSum += rowSum;
                    } else {
                        colSum = rowSum;
                    }
                    if (colSum > colMax) {
                        colMax = colSum;
                    }
                    if (colMax == k) {//找到k了，提前结束
                        return k;
                    }
                    //存储所有的行的和，用于找不到符合条件的k时，再次查找
                    rowSums[i] = rowSum;
                }
                //最大和比k小，本次边界的结果就是最大值，后面就不用找了
                if (colMax < k) {
                    //根据本次边界最大值更新全局的最大值
                    if (colMax > max) {
                        max = colMax;
                    }
                    continue;
                }
                //最大值超过k了，要找和比k小的数中最大的一个
                //暴力搜素
                for (int l = 0; l < rowSums.length; l++) {
                    int s = 0;
                    for (int r = l; r < rowSums.length; r++) {
                        s += rowSums[r];
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

