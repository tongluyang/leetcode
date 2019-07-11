/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (35.63%)
 * Likes:    201
 * Dislikes: 0
 * Total Accepted:    15.9K
 * Total Submissions: 44.3K
 * Testcase Example:  '[1,2,0]'
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 
 * 
 * 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] booleans = new boolean[nums.length];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                booleans[num - 1] = true;
            }
        }
        for (int i = 0; i < booleans.length; i++) {
            if (!booleans[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}

