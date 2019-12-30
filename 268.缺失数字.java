/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 *
 * https://leetcode-cn.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (51.76%)
 * Likes:    190
 * Dislikes: 0
 * Total Accepted:    42.2K
 * Total Submissions: 79K
 * Testcase Example:  '[3,0,1]'
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 示例 1:
 * 
 * 输入: [3,0,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 
 * 
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int max = nums.length; //序列的长度，由于缺失一个数，也是完整序列的最大值
        int sum;
        if (max % 2 == 0) { // 最大值是偶数，如max = 4，完整序列为[0,1,2,3,4]
            sum = max * max / 2 + max / 2;
        } else { // 最大值是奇数，如max = 3，完整序列为[0,1,2,3]
            sum = max * (max + 1) / 2;
        }
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
// @lc code=end

