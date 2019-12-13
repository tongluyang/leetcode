/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 *
 * https://leetcode-cn.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (48.77%)
 * Likes:    30
 * Dislikes: 0
 * Total Accepted:    5.4K
 * Total Submissions: 10.9K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 
 * 示例 1:
 * 
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 
 * 示例 2:
 * 
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 * 
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int pre = nums[0];
        String range = pre + "";
        for (int i = 1; i < nums.length; i++) {
            if (pre + 1 == nums[i]) {
                range = range.endsWith("->") ? range : range + "->";
            } else {//新区间
                range = range.endsWith("->") ? range + pre : range;
                result.add(range);
                range = nums[i] + "";
            }
            pre = nums[i];
        }
        range = range.endsWith("->") ? range + pre : range;
        result.add(range);
        return result;
    }
}
// @lc code=end

