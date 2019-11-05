/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (32.91%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    14.4K
 * Total Submissions: 41.8K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2]
 * 输出: 210
 * 
 * 示例 2:
 * 
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (s1+s2).compareTo(s2+s1));
        StringBuilder sb = new StringBuilder();
        int start = nums.length - 1;
        while (strs[start].equals("0") && start > 0) {
            start--;
        }

        for (int i = start; i >= 0; i--) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }
}
// @lc code=end

