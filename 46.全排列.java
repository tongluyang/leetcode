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
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rem = new ArrayList<>();
        for (int num : nums) {
            rem.add(num);
        }
        permute(result, new ArrayList<>(), rem);
        return result;
    }

    public void permute(List<List<Integer>> result, List<Integer> single, List<Integer> rem) {
        if (rem.size() == 0) {
            result.add(single);
            return;
        }

        for (int i = 0; i < rem.size(); i++) {
            Integer v = rem.get(i);
            single.add(v);
            ArrayList<Integer> newRem = new ArrayList<>(rem);
            newRem.remove(v);
            permute(result, new ArrayList<>(single), newRem);
            single.remove(v);
        }
    }
}

