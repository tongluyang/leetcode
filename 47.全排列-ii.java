/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (52.85%)
 * Likes:    120
 * Dislikes: 0
 * Total Accepted:    16.1K
 * Total Submissions: 30.4K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rem = new ArrayList<>();
        for (int num : nums) {
            rem.add(num);
        }
        Collections.sort(rem);
        permuteUnique(result, new ArrayList<>(), rem);
        return result;
    }


    public void permuteUnique(List<List<Integer>> result, List<Integer> single, List<Integer> rem) {
        if (rem.size() == 0) {
            result.add(single);
            return;
        }

        for (int i = 0; i < rem.size(); i++) {
            if (i > 0 && rem.get(i).equals(rem.get(i - 1))) {
                continue;
            }
            Integer v = rem.get(i);
            single.add(v);
            ArrayList<Integer> newRem = new ArrayList<>(rem);
            newRem.remove(v);
            permuteUnique(result, new ArrayList<>(single), newRem);
            single.remove(single.size() - 1);
        }
    }
}

