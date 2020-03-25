/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 *
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/description/
 *
 * algorithms
 * Easy (56.04%)
 * Likes:    76
 * Dislikes: 0
 * Total Accepted:    13.1K
 * Total Submissions: 21K
 * Testcase Example:  '[[2]]'
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 
 * 请你返回最终形体的表面积。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[2]]
 * 输出：10
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 
 * 
 * 示例 3：
 * 
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 
 * 
 * 示例 4：
 * 
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 
 * 
 * 示例 5：
 * 
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 
 * 
 */

// @lc code=start
class Solution {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int v = grid[i][j];
                if (v == 0) {
                    continue;
                }
                int area = 2;
                //上
                area += area(grid, v, i - 1, j);
                //下
                area += area(grid, v, i + 1, j);
                //左
                area += area(grid, v, i, j - 1);
                //右
                area += area(grid, v, i, j + 1);
                
                sum += area;
            }
        }
        return sum;
    }
    
    private int area(int[][] grid, int v, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return v;
        }
        return v > grid[i][j] ? v - grid[i][j] : 0;
    }
}
// @lc code=end

