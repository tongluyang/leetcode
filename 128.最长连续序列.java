/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (45.66%)
 * Likes:    165
 * Dislikes: 0
 * Total Accepted:    15.5K
 * Total Submissions: 33.1K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 
 * 要求算法的时间复杂度为 O(n)。
 * 
 * 示例:
 * 
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num - 1)) {//存在上级，自己不需要被直接处理了，会被上级找到，算到他的序列里
                continue;
            }
            int length = 1;//从自己开始算，长度1
            while (set.contains(num + 1)) {//往后数
                num++;
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}

