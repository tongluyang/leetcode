/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (40.68%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    28.3K
 * Total Submissions: 69.4K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer result = null;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    final int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    } else {
                        if (result == null) {
                            result = sum;
                        } else {
                            result = Math.abs(result - target) > Math.abs(sum - target) ? sum : result;
                        }
                    }
                }
            }
        }

        return result;
    }
}

