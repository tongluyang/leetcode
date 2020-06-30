/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 *
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (47.77%)
 * Likes:    308
 * Dislikes: 0
 * Total Accepted:    37.1K
 * Total Submissions: 77.1K
 * Testcase Example:  '[1,5,11,5]'
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * 注意:
 * 
 * 
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 
 * 
 * 示例 1:
 * 
 * 输入: [1, 5, 11, 5]
 * 
 * 输出: true
 * 
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 
 * 
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1, 2, 3, 5]
 * 
 * 输出: false
 * 
 * 解释: 数组不能分割成两个元素和相等的子集.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        //dp[i][j]表示从0到i里有没有和为j的数
        boolean[][] dp = new boolean[nums.length][target + 1];
        //从0到0，只有一种可能的和，也就是nums[0]
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {//和为0，代表一个数也不选
                    dp[i][j] = true;
                    continue;
                }
                //         不选nums[i]  ||   选择nums[i]
                dp[i][j] = dp[i - 1][j] || (j - nums[i] >= 0 && dp[i - 1][j - nums[i]]);
                if (dp[i][target]) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

