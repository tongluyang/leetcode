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
        int base = 1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            base *= nums[i];
            max = Math.max(max, base);
            if (nums[i] == 0) {
                base = 1;
            }
        }
        base = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            base *= nums[i];
            max = Math.max(max, base);
            if (nums[i] == 0) {
                base = 1;
            }
        }

        return max;
    }
}
// @lc code=end

