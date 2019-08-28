/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (56.19%)
 * Likes:    118
 * Dislikes: 0
 * Total Accepted:    11.8K
 * Total Submissions: 20.9K
 * Testcase Example:  '[1,2,2]'
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: [1,2,2]
 * 输出:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }
        subsetsWithDup(result, nums, new ArrayList<>(), new boolean[nums.length], 0, 0);
        return result;
    }

    private void subsetsWithDup(ArrayList<List<Integer>> result, int[] nums, List<Integer> single, boolean[] used, int start, int length) {
        if (length > nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            ArrayList<Integer> integers = new ArrayList<>(single);

            if (i == start || nums[i] != nums[i - 1]) {
                integers.add(nums[i]);
                result.add(integers);
                used[i] = true;
                subsetsWithDup(result, nums, integers, used, i + 1, length + 1);
                used[i] = false;
            }
        }

    }
}

