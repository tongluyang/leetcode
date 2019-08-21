/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (44.53%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    6.7K
 * Total Submissions: 14.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * 
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if (matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '0' ? 0 : dp[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(dp));
        }
        return maxArea;
    }

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

