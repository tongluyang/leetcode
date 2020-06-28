/*
 * @lc app=leetcode.cn id=407 lang=java
 *
 * [407] 接雨水 II
 *
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/description/
 *
 * algorithms
 * Hard (39.26%)
 * Likes:    191
 * Dislikes: 0
 * Total Accepted:    3.8K
 * Total Submissions: 9.5K
 * Testcase Example:  '[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]'
 *
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * 
 * 
 * 
 * 示例：
 * 
 * 给出如下 3x6 的高度图:
 * [
 * ⁠ [1,4,3,1,3,2],
 * ⁠ [3,2,1,3,2,4],
 * ⁠ [2,3,3,2,3,1]
 * ]
 * 
 * 返回 4 。
 * 
 * 
 * 
 * 
 * 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
 * 
 * 
 * 
 * 
 * 
 * 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= m, n <= 110
 * 0 <= heightMap[i][j] <= 20000
 * 
 * 
 */

// @lc code=start
class Solution {
    int[][] moves = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        if (row < 3 || col < 3) {//无法产生坑
            return 0;
        }
        int ans = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.h - b.h);
        for (int i = 0; i < row; i++) {
            queue.add(createNode(i, 0, heightMap));
            queue.add(createNode(i, col - 1, heightMap));
        }
        for (int j = 1; j < col - 1; j++) {
            queue.add(createNode(0, j, heightMap));
            queue.add(createNode(row - 1, j, heightMap));
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int[] move : moves) {
                Node n = createNode(node.i + move[0], node.j + move[1], heightMap);
                if (n == null) {
                    continue;
                }
                if (n.h < node.h) {//可以接雨水
                    ans += node.h - n.h;
                    n.h = node.h;//新边界
                }
                queue.add(n);
            }
        }
        return ans;
    }

    private Node createNode(int i, int j, int[][] heightMap) {
        if (i < 0 || j < 0 || i >= heightMap.length || j >= heightMap[0].length) {
            return null;
        }
        if (heightMap[i][j] < 0) {//已经访问过了
            return null;
        }
        Node node = new Node(i, j, heightMap[i][j]);
        heightMap[i][j] = -(heightMap[i][j] + 1);
        return node;
    }

    private static class Node {
        int i;
        int j;
        int h;
        public Node(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }
}
// @lc code=end

