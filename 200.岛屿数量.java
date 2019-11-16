/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.03%)
 * Likes:    271
 * Dislikes: 0
 * Total Accepted:    37.6K
 * Total Submissions: 82.2K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        int row = grid.length;
        if (row == 0) {
            return num;
        }
        int col = grid[0].length;
        if (col == 0) {
            return num;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    mark(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void mark(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) {
            return;
        }
        if (col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '1') {
            grid[row][col] = 'x';
            mark(grid, row + 1, col);
            mark(grid, row - 1, col);
            mark(grid, row, col + 1);
            mark(grid, row, col - 1);
        }
    }
}
// @lc code=end

