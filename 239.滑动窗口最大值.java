/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (42.09%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    22.3K
 * Total Submissions: 51.7K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7] 
 * 解释: 
 * 
 * ⁠ 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 
 * 提示：
 * 
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * 
 * 
 * 
 * 进阶：
 * 
 * 你能在线性时间复杂度内解决此题吗？
 * 
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int[] left = new int[k];
        int[] right = new int[k - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                left[0] = nums[i];
                if (i > 0 && i < nums.length - 1) {//第一组和最后一组不需要right
                    for (int x = 1; x < k; x++) {
                        right[k - 1 - x] = x == 1 ? nums[i - x] : Math.max(nums[i - x], right[k - x]);
                    }
                }
            } else {
                left[i % k] = Math.max(left[(i % k) - 1], nums[i]);
            }
            if (i >= k - 1) {
                result[i - (k - 1)] = i % k == k - 1 ? left[k - 1] : Math.max(left[i % k], right[i % k]);
            }
        }
        return result;
    }
}
// @lc code=end

