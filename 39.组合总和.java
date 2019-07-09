/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (65.55%)
 * Likes:    300
 * Dislikes: 0
 * Total Accepted:    23K
 * Total Submissions: 35.1K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        bt(result, list, candidates, 0, 0, target);

        return result;
    }

    public void bt(List<List<Integer>> result, List<Integer> list, int[] candidates, int startIndex, int sum, int target) {
        if (sum == target) {
            result.add(list);
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            ArrayList<Integer> integers = new ArrayList<>(list);
            integers.add(candidate);
            bt(result, integers, candidates, i, sum + candidate, target);
        }

    }
}

