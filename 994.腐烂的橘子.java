/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 *
 * https://leetcode-cn.com/problems/rotting-oranges/description/
 *
 * algorithms
 * Easy (46.69%)
 * Likes:    110
 * Dislikes: 0
 * Total Accepted:    11.2K
 * Total Submissions: 23.1K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 
 * 
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 
 * 
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 
 * 
 * 示例 3：
 * 
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 * 
 * 
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return -1;
        }
        int col = grid[0].length;
        if (col == 0) {
            return -1;
        }
        int fresh = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        if (queue.isEmpty()) {
            return -1;
        }
        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size() / 2;
            for (int x = 0; x < size; x++) {
                int i = queue.poll();
                int j = queue.poll();
                add(queue, grid, i + 1, j);
                add(queue, grid, i - 1, j);
                add(queue, grid, i, j + 1);
                add(queue, grid, i, j - 1);
            }
            fresh -= queue.size() / 2;
            time++;
        }
        if (fresh > 0) {
            return -1;
        }
        return time;
    }
    
    private void add(Queue<Integer> queue, int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            queue.add(i);
            queue.add(j);
        }
    }
}
// @lc code=end

