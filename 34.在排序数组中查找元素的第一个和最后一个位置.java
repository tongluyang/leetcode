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
        int[] range = {-1, -1};


        if (nums.length == 0) {
            return range;
        }

        if (nums[0] > target) {
            return range;
        }

        if (nums[nums.length - 1] < target) {
            return range;
        }

        int mid = nums.length / 2;

        int start = 0;
        int end = nums.length - 1;
        for (int i = mid; i < nums.length;) {
            if (nums[i] > target) {
                end = i;
                i = i / 2;
                continue;
            }

            if (nums[i] < target) {
                start = (i + end) / 2 + (i + end) % 2;
                if (start == end && nums[start] != target) {
                    return range;
                }
                i = start;
                continue;
            }

            mid = i;

            while (true) {
                if (i == 0) {
                    start = 0;
                    break;
                }
                if (nums[--i] != target) {
                    start = i + 1;
                    break;
                }
            }

            i = mid;

            while (true) {
                if (i == nums.length - 1) {
                    end = i;
                    break;
                }
                if (nums[++i] != target) {
                    end = i - 1;
                    break;
                }
            }

            break;
        }

        range[0] = start;
        range[1] = end;


        return range;
    }
}

