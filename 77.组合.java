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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        bt(0, k, 0, n, new ArrayList<>());
        return ans;
    }

    private void bt(int count, int k, int last, int n, List<Integer> list) {
        if (count == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (n - last < k - count) {
            return;
        }
        list.add(last + 1);
        bt(count + 1, k, last + 1, n, list);
        list.remove(list.size() - 1);
        bt(count, k, last + 1, n, list);
    }
}

