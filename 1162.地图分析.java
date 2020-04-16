/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 *
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/description/
 *
 * algorithms
 * Medium (47.21%)
 * Likes:    114
 * Dislikes: 0
 * Total Accepted:    22.9K
 * Total Submissions: 48.7K
 * Testcase Example:  '[[1,0,1],[0,0,0],[1,0,1]]'
 *
 * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1
 * 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
 * 
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 -
 * x1| + |y0 - y1| 。
 * 
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释： 
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释： 
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxDistance(int[][] grid) {
        int res = -1;
        int row = grid.length;
        if (row == 0) {
            return res;
        }
        int col = grid[0].length;
        if (col == 0) {
            return res;
        }
        boolean[][] visited = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                }
            }
        }
        if (queue.isEmpty() || queue.size() / 2 == row * col) {
            return res;
        }
        res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size() / 2;
            for (int x = 0; x < size; x++) {
                int i = queue.poll();
                int j = queue.poll();

                check(grid, i - 1, j, visited, queue);
                check(grid, i + 1, j, visited, queue);
                check(grid, i, j - 1, visited, queue);
                check(grid, i, j + 1, visited, queue);
            }
            res++;
        }
        return res - 1;
    }

    private void check(int[][] grid, int i, int j, boolean[][] visited, Queue<Integer> queue) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !visited[i][j] && grid[i][j] == 0) {
            visited[i][j] = true;
            queue.add(i);
            queue.add(j);
        }
    }
}
// @lc code=end

