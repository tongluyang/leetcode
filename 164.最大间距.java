/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 *
 * https://leetcode-cn.com/problems/maximum-gap/description/
 *
 * algorithms
 * Hard (51.13%)
 * Likes:    81
 * Dislikes: 0
 * Total Accepted:    6.7K
 * Total Submissions: 12.8K
 * Testcase Example:  '[3,6,9,1]'
 *
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 
 * 如果数组元素个数小于 2，则返回 0。
 * 
 * 示例 1:
 * 
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 
 * 示例 2:
 * 
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 
 * 说明:
 * 
 * 
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * 
 * 
 */

// @lc code=start
class Solution {
    private static class Bucket {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max == min) {
            return 0;
        }
        int minGap = (max - min) / (nums.length - 1);
        minGap = minGap == 0 ? 1 : minGap;
        int maxGap = minGap;
        Bucket[] buckets = new Bucket[(max - min) / minGap + 1];
        for (int num : nums) {
            int i = (num - min) / minGap;
            if (buckets[i] == null) {
                buckets[i] = new Bucket();
            }
            buckets[i].max = Math.max(buckets[i].max, num);
            buckets[i].min = Math.min(buckets[i].min, num);
        }

        Bucket prev = buckets[0];
        Bucket post;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] != null) {
                post = buckets[i];
                maxGap = Math.max(maxGap, post.min - prev.max);
                prev = post;
            }
        }

        return maxGap;
    }
}
// @lc code=end

