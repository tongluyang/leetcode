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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        bt(0, n, 1, new ArrayList<>(), k);
        return ans;
    }

    private void bt(int sum, int n, int i, List<Integer> list, int k) {
        if (sum == n && list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (sum > n || i > n || i > 9) {
            return;
        }
        list.add(i);
        bt(sum + i, n, i + 1, list, k);
        list.remove(list.size() - 1);
        bt(sum, n, i + 1, list, k);
    }
}
// @lc code=end

