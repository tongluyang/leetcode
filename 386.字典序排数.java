/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 *
 * https://leetcode-cn.com/problems/lexicographical-numbers/description/
 *
 * algorithms
 * Medium (69.84%)
 * Likes:    86
 * Dislikes: 0
 * Total Accepted:    8.7K
 * Total Submissions: 12.4K
 * Testcase Example:  '13'
 *
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * 
 * 例如，
 * 
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * 
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9 && i <= n; i++) {
            gen(i, res, n);
        }
        return res;
    }

    private void gen(int i, List<Integer> res, int n) {
        res.add(i);
        for (int j = 0; j <= 9; j++) {
            int next = i * 10 + j;
            if (next > n) {
                return;
            }
            gen(next, res, n);
        }
    }
}
// @lc code=end

