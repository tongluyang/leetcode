/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (35.27%)
 * Likes:    286
 * Dislikes: 0
 * Total Accepted:    23.1K
 * Total Submissions: 64.8K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        //dp[0] 最大积
        //dp[1] 负基数
        //dp[2] 基数
        Integer[][] dp = new Integer[3][nums.length];
        dp[0][0] = nums[0];
        if (nums[0] > 0) {
            dp[2][0] = nums[0];
        } else if (nums[0] < 0) {
            dp[1][0] = nums[0];
            dp[2][0] = 1;
        } else {
            dp[2][0] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[0][i] = Integer.max(dp[0][i - 1], 0);
                dp[2][i] = 1;
            } else if (nums[i] > 0) {
                dp[0][i] = Integer.max(dp[2][i - 1] * nums[i], dp[0][i - 1]);
                if (dp[1][i - 1] != null) {
                    dp[1][i] = dp[1][i - 1] * nums[i];
                }
                dp[2][i] = dp[2][i - 1] * nums[i];
            } else {
                if (dp[1][i - 1] != null) {
                    dp[0][i] = Integer.max(dp[1][i - 1] * nums[i], dp[0][i - 1]);
                    dp[1][i] = dp[2][i - 1] * nums[i];
                    dp[2][i] = dp[1][i - 1] * nums[i];
                } else {
                    dp[0][i] = Integer.max(dp[0][i - 1], nums[0]);
                    dp[1][i] = nums[i];
                    dp[2][i] = 1;
                }
                dp[1][i] = dp[2][i - 1] * nums[i];
            }
        }

        return dp[0][nums.length - 1];
    }
}
// @lc code=end

