/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (69.75%)
 * Likes:    313
 * Dislikes: 0
 * Total Accepted:    32.6K
 * Total Submissions: 46.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> seq, int[] nums, boolean[] visited) {
        if (seq.size() == nums.length) {
            res.add(seq);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            List<Integer> newSeq = new ArrayList<>(seq);
            newSeq.add(nums[i]);
            visited[i] = true;
            backtrack(res, newSeq, nums, visited);
            visited[i] = false;
        }
    }
}

