/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 *
 * https://leetcode-cn.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (41.91%)
 * Likes:    146
 * Dislikes: 0
 * Total Accepted:    11.4K
 * Total Submissions: 27.1K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 
 * 示例:
 * 
 * 
 * nums = [1, 2, 3]
 * target = 4
 * 
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * 请注意，顺序不同的序列被视作不同的组合。
 * 
 * 因此输出为 7。
 * 
 * 
 * 进阶：
 * 如果给定的数组中含有负数会怎么样？
 * 问题会产生什么变化？
 * 我们需要在题目中添加什么限制来允许负数的出现？
 * 
 * 致谢：
 * 特别感谢 @pbrother 添加此问题并创建所有测试用例。
 * 
 */

// @lc code=start
class Solution {
    Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        return bt(nums, 0, target);
    }

    public int bt(int[] nums, int sum, int target) {
        if (sum == target) {
            return 1;
        }
        if (sum > target) {
            return 0;
        }
        if (mem.get(sum) != null && mem.get(sum).get(target) != null) {
            return mem.get(sum).get(target);
        }
        int count = 0;
        for (int num : nums) {
            count += bt(nums, sum + num, target);
        }
        if (mem.get(sum) == null) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(target, count);
            mem.put(sum, map);
        } else {
            mem.get(sum).put(target, count);
        }
        return count;
    }
}
// @lc code=end

