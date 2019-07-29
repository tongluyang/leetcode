/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (36.11%)
 * Likes:    180
 * Dislikes: 0
 * Total Accepted:    18.5K
 * Total Submissions: 50.5K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int[] border = new int[]{0, matrix[0].length - 1, matrix.length - 1, 0};
        spiralOrder(matrix, result, border, 3, 1, 0, true);
        return result;
    }

    public void spiralOrder(int[][] matrix, List<Integer> result, int[] border, int borderIndex, int inc, int x, boolean isRow) {
        for (int i = border[borderIndex % 4]; i != border[(borderIndex + 2) % 4] + inc; i = i + inc) {
            int value;
            if (isRow) {
                value = matrix[x][i];
            } else {
                value = matrix[i][x];
            }
            result.add(value);
        }
        border[(borderIndex + 1) % 4] = border[(borderIndex + 1) % 4] + ((borderIndex + 2) % 4 > 1 ? -1: 1);
        if (border[0] > border[2] || border[3] > border[1]) {
            return;
        }
        spiralOrder(matrix, result, border, borderIndex + 1, (borderIndex + 2) % 4 > 1 ? -1: 1, border[(borderIndex + 2) % 4], !isRow);
    }
}

