/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (55.87%)
 * Likes:    111
 * Dislikes: 0
 * Total Accepted:    15.7K
 * Total Submissions: 28.1K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        bt2(result, list, candidates, -1, 0, target);

        return result;
    }

    public void bt2(List<List<Integer>> result, List<Integer> list, int[] candidates, int startIndex, int sum, int target) {
        if (sum == target) {

            if (!result.contains(list)) {
                result.add(list);
            }

            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = startIndex + 1; i < candidates.length; i++) {
            int candidate = candidates[i];
            ArrayList<Integer> integers = new ArrayList<>(list);
            integers.add(candidate);
            bt2(result, integers, candidates, i, sum + candidate, target);
        }

    }
}

