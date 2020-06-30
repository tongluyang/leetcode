/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 *
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (41.84%)
 * Likes:    113
 * Dislikes: 0
 * Total Accepted:    9.2K
 * Total Submissions: 21.8K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 
 * 给定下面的 5x5 矩阵:
 * 
 * ⁠ 太平洋 ~   ~   ~   ~   ~ 
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * 大西洋
 * 
 * 返回:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return ans;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return ans;
        }
        Boolean[][] pacific = new Boolean[row][col];
        Boolean[][] atlantic = new Boolean[row][col];
        //bfs
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            pacific[i][0] = true;
            pacificQueue.add(new int[]{i, 0});
            atlantic[i][col - 1] = true;
            atlanticQueue.add(new int[]{i, col - 1});
        }
        for (int j = 0; j < col; j++) {
            pacific[0][j] = true;
            pacificQueue.add(new int[]{0, j});
            atlantic[row - 1][j] = true;
            atlanticQueue.add(new int[]{row - 1, j});
        }
        
        bfs(pacificQueue, matrix, pacific);
        bfs(atlanticQueue, matrix, atlantic);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] != null && atlantic[i][j] != null && pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    int[][] actions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private void bfs(Queue<int[]> queue, int[][] matrix, Boolean[][] dp) {
        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            int i = idx[0];
            int j = idx[1];
            int h = matrix[i][j];
            for (int[] action : actions) {
                if (update(matrix, dp, i + action[0], j + action[1], h)) {
                    queue.add(new int[]{i + action[0], j + action[1]});
                }
            }
        }
    }

    private boolean update(int[][] matrix, Boolean[][] dp, int i, int j, int h) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        if (dp[i][j] != null) {
            return false;
        }
        if (matrix[i][j] >= h) {
            return dp[i][j] = true;
        }
        return false;
    }
}
// @lc code=end

