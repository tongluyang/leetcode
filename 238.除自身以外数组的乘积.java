/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 *
 * https://leetcode-cn.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (62.21%)
 * Likes:    259
 * Dislikes: 0
 * Total Accepted:    22.7K
 * Total Submissions: 35.1K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i]
 * 之外其余各元素的乘积。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * 
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int num = 1;
        for (int i = 0; i < length - 1; i++) {
            result[i] = num *= nums[i];
        }
        num = 1;
        for (int i = length - 1; i > 0; i--) {
            nums[i] = num *= nums[i];
        }
        result[length - 1] = result[length - 2];
        for (int i = length - 2; i > 0; i--) {
            result[i] = result[i - 1] * nums[i + 1];
        }
        result[0] = nums[1];
        return result;
    }
}
// @lc code=end

