/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 *
 * https://leetcode-cn.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (18.06%)
 * Likes:    84
 * Dislikes: 0
 * Total Accepted:    5.4K
 * Total Submissions: 28.8K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 
 * 示例 1:
 * 
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }

        int max = 0;
        int maxSame = 0;
        for (int i = 0; i < points.length - 2; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int same = 0;
            for (int j = i + 1; j < points.length - 1; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    same++;
                    maxSame = Math.max(2 + same, maxSame);
                    continue;
                }
                int pointCount = 2 + same;
                for (int k = j + 1; k < points.length; k++) {
                    int x = points[k][0];
                    int y = points[k][1];

                    if ((long) (x1 - x2) * (y1 - y) == (long) (x1 - x) * (y1 - y2)) {
                        pointCount++;
                    }
                }
                max = Math.max(max, pointCount);
            }
        }
        return max == 0 ? maxSame : max;
    }
}
// @lc code=end

