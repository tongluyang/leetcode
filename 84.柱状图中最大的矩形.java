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
        if (heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int right = 0; right <= heights.length; right++) {
            while (true) {
                if (right < heights.length && (stack.peek() == -1 || heights[right] > heights[stack.peek()])) {
                    stack.push(right);
                    break;
                } else {
                    int h = heights[stack.pop()];
                    int left = stack.peek();

                    int area = h * (right - left - 1);

                    max = Math.max(max, area);

                    if (right == heights.length && stack.peek() == -1) {
                        break;
                    }
                }
            }
        }
        return max;
    }
}

