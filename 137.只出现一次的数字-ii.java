/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 *
 * https://leetcode-cn.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (64.55%)
 * Likes:    195
 * Dislikes: 0
 * Total Accepted:    13.8K
 * Total Submissions: 21.4K
 * Testcase Example:  '[2,2,3,2]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,3,2]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * 
 */

// @lc code=start
class Solution {
    /**
     * h | l | i | h'| l'
     * -------------------
     * 0 | 0 | 0 | 0 | 0    => no input, no change
     * -------------------
     * 0 | 1 | 0 | 0 | 1    => no input, no change
     * -------------------
     * 1 | 0 | 0 | 1 | 0    => no input, no change
     * -------------------
     * 0 | 0 | 1 | 0 | 1    => 00 -> 01
     * -------------------
     * 0 | 1 | 1 | 1 | 0    => 01 -> 10
     * -------------------
     * 1 | 0 | 1 | 0 | 0    => 10 -> 00
     */
    public int singleNumber(int[] nums) {
        int high = 0;
        int lower = 0;
        int newHigh = 0;
        int newLower = 0;

        for (int num : nums) {
            newHigh = high & ~lower & ~num | ~high & lower & num;
            newLower = ~high & lower & ~num | ~high & ~lower & num;
            high = newHigh;
            lower = newLower;
        }
        return lower;
    }
}
// @lc code=end

