/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 *
 * https://leetcode-cn.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (38.20%)
 * Likes:    209
 * Dislikes: 0
 * Total Accepted:    20K
 * Total Submissions: 47.6K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 
 * 两个相邻元素间的距离为 1 。
 * 
 * 示例 1: 
 * 输入:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 
 * 输出:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 
 * 示例 2: 
 * 输入:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 
 * 
 * 输出:
 * 
 * 
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 
 * 
 * 注意:
 * 
 * 
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return matrix;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return matrix;
        }
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(res[i], 10000);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = matrix[i][j] == 0 ? 0 : min(i, j, -1, res);
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                res[i][j] = matrix[i][j] == 0 ? 0 : min(i, j, 1, res);
            }
        }
        return res;
    }
    
    public int min(int i, int j, int step, int[][] res) {
        int n1 = (i + step < 0 || i + step >= res.length) ? 10000 : res[i + step][j];
        int n2 = (j + step < 0 || j + step >= res[0].length) ? 10000 : res[i][j + step];
        int min = Math.min(
                Math.min(n1, n2) + 1,
                res[i][j]
            );
        return min;
    }
}
// @lc code=end

