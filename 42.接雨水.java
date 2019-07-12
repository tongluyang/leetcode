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
        int sumArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            int left = height[i];
            int next = height[i + 1];

            int minus = left - next;
            if (minus <= 0) {
                continue;
            }

            for (int unit = 1; unit <= minus; unit++) {
                int w = 1;
                while (true) {
                    if (i + w >= height.length) {
                        w = 0;
                        break;
                    }
                    if (height[i + w] <= left - unit) {
                        w++;
                    } else {
                        w--;
                        break;
                    }
                }
                sumArea += w;
            }

        }

        return sumArea;
    }
}

