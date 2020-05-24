/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (35.08%)
 * Likes:    1129
 * Dislikes: 0
 * Total Accepted:    59.7K
 * Total Submissions: 170K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (getKth(nums1, nums2, 0, 0, len / 2) + getKth(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
        }
        return getKth(nums1, nums2, 0, 0, len / 2 + 1);
    }

    private int getKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid = k / 2;
        int end1 = Math.min(start1 + mid - 1, nums1.length - 1);
        int end2 = Math.min(start2 + mid - 1, nums2.length - 1);
        if (nums1[end1] < nums2[end2]) {
            return getKth(nums1, nums2, end1 + 1, start2, k - (end1 + 1 - start1));
        }
        return getKth(nums1, nums2, start1, end2 + 1, k - (end2 + 1 - start2));
    }
}