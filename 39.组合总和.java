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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(0, target, new ArrayList<>(), candidates, 0);
        return ans;
    }

    private void bt(int sum, int target, List<Integer> list, int[] candidates, int i) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i >= candidates.length) {
            return;
        }
        if (sum > target) {
            return;
        }
        list.add(candidates[i]);
        bt(sum + candidates[i], target, list, candidates, i);
        list.remove(list.size() - 1);
        bt(sum, target, list, candidates, i + 1);
    }
}

