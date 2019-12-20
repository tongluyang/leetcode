/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/
 *
 * algorithms
 * Medium (37.28%)
 * Likes:    188
 * Dislikes: 0
 * Total Accepted:    34.2K
 * Total Submissions: 89.8K
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n5'
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 
 * 
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 
 * 
 * 示例:
 * 
 * 现有矩阵 matrix 如下：
 * 
 * [
 * ⁠ [1,   4,  7, 11, 15],
 * ⁠ [2,   5,  8, 12, 19],
 * ⁠ [3,   6,  9, 16, 22],
 * ⁠ [10, 13, 14, 17, 24],
 * ⁠ [18, 21, 23, 26, 30]
 * ]
 * 
 * 
 * 给定 target = 5，返回 true。
 * 
 * 给定 target = 20，返回 false。
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int row = matrix.length;
        if (row == 0) {
            return false;
        }
        final int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        return searchMatrix(matrix, target, 0, 0, row - 1, col - 1);
    }

    public boolean searchMatrix(int[][] matrix, int target, int minI, int minJ, int maxI, int maxJ) {
        if (minI > maxI || minJ > maxJ) {
            return false;
        }
        if (minI == maxI && minJ == maxJ) {
            return matrix[minI][minJ] == target;
        }

        int midI = (minI + maxI) >>> 1;
        int midJ = (minJ + maxJ) >>> 1;

        //向右下，中心
        if (matrix[midI][midJ] == target) {
            return true;
        }
        if (target > matrix[midI][midJ]) {//目标比中心点大，左上角不用考虑了
            return searchMatrix(matrix, target, midI + 1, minJ, maxI, maxJ) //下
                    || searchMatrix(matrix, target, minI, midJ + 1, midI, maxJ); //右
        } else {//目标比中心点小，右下角不用考虑了
            return searchMatrix(matrix, target, minI, minJ, midI - 1, maxJ) //上
                    || searchMatrix(matrix, target, midI, minJ, maxI, midJ - 1); //左
        }
    }
}
// @lc code=end

