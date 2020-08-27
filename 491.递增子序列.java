/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 *
 * https://leetcode-cn.com/problems/increasing-subsequences/description/
 *
 * algorithms
 * Medium (56.03%)
 * Likes:    192
 * Dislikes: 0
 * Total Accepted:    27.1K
 * Total Submissions: 48.4K
 * Testcase Example:  '[4,6,7,7]'
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 
 * 示例:
 * 
 * 
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7],
 * [4,7,7]]
 * 
 * 说明:
 * 
 * 
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void bt(List<List<Integer>> ans, List<Integer> list, int[] nums, int cur) {
        if (cur >= nums.length) {
            if (list.size() > 1) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (list.isEmpty() || nums[cur] >= list.get(list.size() - 1)) {
            list.add(nums[cur]);
            bt(ans, list, nums, cur + 1);
            list.remove(list.size() - 1);
        }
        if (list.isEmpty() || nums[cur] != list.get(list.size() - 1)) {
            bt(ans, list, nums, cur + 1);
        }
    }
}
// @lc code=end

