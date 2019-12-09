/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 *
 * https://leetcode-cn.com/problems/rectangle-area/description/
 *
 * algorithms
 * Medium (41.19%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    4.8K
 * Total Submissions: 11.6K
 * Testcase Example:  '-3\n0\n3\n4\n0\n-1\n9\n2'
 *
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * 
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 
 * 说明: 假设矩形面积不会超出 int 的范围。
 * 
 */

// @lc code=start
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area;
        if (B >= H || F >= D || E >= C || A >= G) {
            area = 0;
        } else {
            area = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - area;
    }
}
// @lc code=end

