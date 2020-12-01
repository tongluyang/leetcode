/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (36.82%)
 * Likes:    146
 * Dislikes: 0
 * Total Accepted:    22.1K
 * Total Submissions: 60.2K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length - 1);
    }

    private int[] searchRange(int[] nums, int target, int start, int end) {
        if (start > end) {
            return new int[]{-1, -1};
        }
        if (start == end) {
            if (nums[start] == target) {
                return new int[]{start, start};
            }
            return new int[]{-1, -1};
        }
        int mid = (start + end) >>> 1;
        int[] left;
        int[] right;
        if (nums[mid] > target) {
            left = searchRange(nums, target, start, mid);
            right = new int[]{-1, -1};
        } else if (nums[mid] < target) {
            left = new int[]{-1, -1};
            right = searchRange(nums, target, mid + 1, end);
        } else {
            left = searchRange(nums, target, start, mid);
            right = searchRange(nums, target, mid + 1, end);
        }
        if (left[1] == -1) {
            return right;
        }
        if (right[0] == -1) {
            return left;
        }
        return new int[]{left[0], right[1]};
    }
}

