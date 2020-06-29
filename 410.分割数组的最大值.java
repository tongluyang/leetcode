/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 *
 * https://leetcode-cn.com/problems/split-array-largest-sum/description/
 *
 * algorithms
 * Hard (43.44%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    7.3K
 * Total Submissions: 16.7K
 * Testcase Example:  '[7,2,5,10,8]\n2'
 *
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 
 * 注意:
 * 数组长度 n 满足以下条件:
 * 
 * 
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 
 * 
 * 示例: 
 * 
 * 
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * 输出:
 * 18
 * 
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    int[][] mem;
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        mem = new int[nums.length][m + 1];
        return helper(nums, 0, m, sum);
    }

    private int helper(int[] nums, int start, int m, long s) {
        if (start == nums.length - 1) {
            return nums[nums.length - 1];
        }
        if (m == 1) {
            return (int) s;
        }
        if (mem[start][m] > 0) {
            return mem[start][m];
        }
        long sum = 0;
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            if (sum == s / m) {//平均分
                return mem[start][m] = helper(nums, i + 1, m - 1, s - sum);
            } else if (sum > s / m) {
                return mem[start][m] = (int) Math.min(
                    helper(nums, i, m - 1, s - sum + nums[i]),
                    Math.max(sum, helper(nums, i + 1, m - 1, s - sum)));
            }
        }
        return mem[start][m] = (int) sum;
    }
}
// @lc code=end

