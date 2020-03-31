/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 *
 * https://leetcode-cn.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (53.45%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    31.8K
 * Total Submissions: 55.5K
 * Testcase Example:  '[5,2,3,1]'
 *
 * 给你一个整数数组 nums，将该数组升序排列。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        int min = -50000;
        int max = 50000;
        int[] count = new int[max - min + 1];
        int[] sorted = new int[nums.length];
        for (int num : nums) {
            count[num - min]++;
        }
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sorted[idx] = i + min;
                idx++;
                count[i]--;
            }
        }
        return sorted;
    }
}
// @lc code=end

