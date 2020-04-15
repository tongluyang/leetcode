import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 *
 * https://leetcode-cn.com/problems/count-of-range-sum/description/
 *
 * algorithms
 * Hard (32.95%)
 * Likes:    69
 * Dislikes: 0
 * Total Accepted:    2.9K
 * Total Submissions: 8.7K
 * Testcase Example:  '[-2,5,-1]\n-2\n2'
 *
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * 
 * 说明:
 * 最直观的算法复杂度是 O(n^2) ，请在此基础上优化你的算法。
 * 
 * 示例:
 * 
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3 
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        // lower <= sum[j] - sum[i] <= upper
        // lower - sum[j] <= -sum[i] <= upper - sum[j]
        // -lower + sum[j] >= sum[i] >= -upper + sum[j]
        // sum[j] - upper <= sum[i] <= sum[j] - lower
        // 在sum的[0, j]里找有多少个符合上述条件的sum[i]（其中i<j，因为至少要包含一个元素，一个元素是sum[i] - sum[i - 1]）
        long sumj = 0;
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);//初始为0，相当于sum[-1]=0，num[0]=sum[0]-sum[-1]
        for (int num : nums) {
            sumj += num;
            //因为i要比j小，所以sumj不在寻找范围，先找再放
            count += map.subMap(sumj - upper, sumj - lower + 1).values().stream().mapToInt(Integer::intValue).sum();
            map.put(sumj, map.getOrDefault(sumj, 0) + 1);
        }
        return count;
    }
}
// @lc code=end

