/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 *
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (34.11%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    14.4K
 * Total Submissions: 40.8K
 * Testcase Example:  '[2,3,2]'
 *
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0];
        nums[0] = 0;
        int max = rob198(nums);
        nums[0] = first;
        nums[nums.length - 1] = 0;
        return Math.max(max, rob198(nums));
    }

    public int rob198(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        int[][] dp = new int[2][size];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = (i == 1 ? dp[0][i - 1] : Math.max(dp[0][i - 1], dp[0][i - 2])) + nums[i];
        }
        return Math.max(dp[0][size - 1], dp[1][size - 1]);
    }
}
// @lc code=end

