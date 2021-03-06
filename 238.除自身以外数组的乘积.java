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
        int len = nums.length;
        //left[i]为i左侧所有num的乘积
        //right[i]为i右侧所有num的乘积
        //可以用res作为left，nums作为right，空间O(1)
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = i == 0 ? 1 : left[i - 1] * nums[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            right[i] = i == len - 1 ? 1 : right[i + 1] * nums[i + 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
// @lc code=end

