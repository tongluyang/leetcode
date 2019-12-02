/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (68.64%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    10.6K
 * Total Submissions: 15.3K
 * Testcase Example:  '3\n7'
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(result, new ArrayList<>(), k, n, 1, 0, 0);
        return result;
    }

    private void combinationSum3(List<List<Integer>> result, List<Integer> single, int k, int n, int start, int count, int sum) {
        if (count == k - 1) {
            int rem = n - sum;
            if (rem >= start && rem <= 9) {
                single.add(rem);
                result.add(single);
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            List<Integer> list = new ArrayList<>(single);
            list.add(i);
            combinationSum3(result, list, k, n, i + 1, count + 1, sum + i);
        }
    }
}
// @lc code=end

