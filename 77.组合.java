/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (69.75%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    16.3K
 * Total Submissions: 23.4K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        combine(result, new ArrayList<>(), n, k);

        return result;
    }

    public void combine(List<List<Integer>> result, List<Integer> single, int n, int k) {
        if (single.size() == k) {
            result.add(new ArrayList<>(single));
            return;
        }

        for (int i = single.isEmpty() ? 1 : single.get(single.size() - 1) + 1; i <= n; i++) {
            single.add(i);
            combine(result, single, n, k);
            single.remove(single.size() - 1);
        }
    }
}

