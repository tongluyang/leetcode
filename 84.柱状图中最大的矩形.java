/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (37.97%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    10.6K
 * Total Submissions: 27.9K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 * 
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        heights = tmp;
        for (int i = 0; i < heights.length; i++) {
            if (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int idx = stack.pop();
                    int height = heights[idx];
                    int width = i - stack.peek() - 1;
                    max = Math.max(max, height * width);
                }
            }
            stack.push(i);
        }
        return max;
    }
}

