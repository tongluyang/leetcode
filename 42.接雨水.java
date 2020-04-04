/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (44.34%)
 * Likes:    462
 * Dislikes: 0
 * Total Accepted:    17.9K
 * Total Submissions: 40.2K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;
        if (len <= 2) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        for (int rightIdx = 0; rightIdx < len; rightIdx++) {
            while (!stack.isEmpty() && height[rightIdx] > height[stack.peek()]) {
                int bottomIdx = stack.pop();
                if (!stack.isEmpty()) {
                    int leftIdx = stack.peek();
                    int h = Math.min(height[leftIdx], height[rightIdx]) - height[bottomIdx];
                    int d = rightIdx - leftIdx - 1;
                    res += h * d;
                }
            }
            stack.add(rightIdx);
        }
        return res;
    }
}

