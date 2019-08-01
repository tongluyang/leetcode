/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (73.26%)
 * Likes:    112
 * Dislikes: 0
 * Total Accepted:    12.5K
 * Total Submissions: 17K
 * Testcase Example:  '3'
 *
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int row = 0;
        int col = 0;
        int value = 2;
        matrix[0][0] = 1;

        while (value <= n * n) {
            for (int i = col + 1; i < n && matrix[row][col + 1] == 0; i++) {
                col = i;
                matrix[row][col] = value++;
            }

            for (int i = row + 1; i < n && matrix[row + 1][col] == 0; i++) {
                row = i;
                matrix[row][col] = value++;
            }

            for (int i = col - 1; i >= 0 && matrix[row][col - 1] == 0; i--) {
                col = i;
                matrix[row][col] = value++;
            }

            for (int i = row - 1; i >= 0 && matrix[row - 1][col] == 0; i--) {
                row = i;
                matrix[row][col] = value++;
            }
        }

        return matrix;
    }
}

