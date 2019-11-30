/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (57.92%)
 * Likes:    293
 * Dislikes: 0
 * Total Accepted:    58.8K
 * Total Submissions: 99.1K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int p = nums[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (nums[r] > p && r > l) {
                r--;
            }
            while (nums[l] <= p && r > l) {
                l++;
            }
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
        }
        int tmp = nums[r];
        nums[r] = p;
        nums[start] = tmp;

        int rightLen = end - r;
        if (k == rightLen + 1) {//左边数组第一个，也就是最大值，也就是分界数
            return p;
        }

        if (k <= rightLen) {//在大的一边
            return findKthLargest(nums, k, r + 1, end);
        } else {
            return findKthLargest(nums, k - rightLen - 1, start, r - 1);
        }
    }
}
// @lc code=end

