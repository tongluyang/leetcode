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
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = len - 1;
            for (int j = i + 1; j < len - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > target) {
                    if (nums[i] + nums[j] + nums[k] - target < Math.abs(res - target)) {
                        res = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                }
                if (j >= k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == target) {
                    return target;
                }
                if (target - (nums[i] + nums[j] + nums[k]) < Math.abs(res - target)) {
                    res = nums[i] + nums[j] + nums[k];
                }
            }
        }
        return res;
    }
}

