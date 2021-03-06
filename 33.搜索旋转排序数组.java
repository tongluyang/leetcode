/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.59%)
 * Likes:    280
 * Dislikes: 0
 * Total Accepted:    29.1K
 * Total Submissions: 79.7K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int min = 0;
        int max = nums.length - 1;

        while (min < max) {
            int mid = (min + max) / 2;

            if (nums[mid] >= nums[0]) {//开始到中间是递增，无旋转点
                if (target >= nums[0] && target <= nums[mid]) {//目标在前半部分
                    max = mid;
                } else {//目标在后半部分
                    min = mid + 1;
                }
            } else {//有旋转
                if (target <= nums[mid] || target >= nums[0]) {//target在最小到中间或0到最大
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
        }

        return nums[min] == target ? min : -1;
    }
}

