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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int[] all = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, all, 0, nums1.length);
        System.arraycopy(nums2, 0, all, nums1.length, nums2.length);

        final List<Integer> ints = new ArrayList<>();
        for (int i : all) {
            ints.add(i);
        }

        //O(log(m + n))
        //快排
        Collections.sort(ints);

        if (ints.size() % 2 == 1) {
            return ints.get((ints.size() - 1) / 2);
        } else {
            return (ints.get((ints.size() / 2)) + ints.get((ints.size() / 2 - 1))) / 2.0;
        }
    }
}

