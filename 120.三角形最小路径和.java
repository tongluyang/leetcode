/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (60.94%)
 * Likes:    212
 * Dislikes: 0
 * Total Accepted:    22.3K
 * Total Submissions: 36.1K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int i = triangle.size() - 1;
        for (; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            if (i > 0) {
                List<Integer> pre = triangle.get(i - 1);
                for (int j = 0; j < pre.size(); j++) {
                    pre.set(j, pre.get(j) + Math.min(row.get(j), row.get(j + 1)));
                }
            }
        }
        return triangle.get(0).get(0);
    }
}
