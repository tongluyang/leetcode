/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (63.26%)
 * Likes:    191
 * Dislikes: 0
 * Total Accepted:    10.6K
 * Total Submissions: 16.4K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */
class Solution {
    List<List<String>> allAns = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        bt(0, 0, n, new ArrayList<>());
        return allAns;
    }

    private boolean bt(int i, int j, int n, List<String> ans) {
        if (i == n) {
            allAns.add(new ArrayList<>(ans));
            return true;
        }
        if (i >= n || j < 0 || j >= n) {
            return false;
        }
        if (check(j, ans)) {
            ans.add(buildRow(j, n));
            bt(i + 1, 0, n, ans);
            ans.remove(ans.size() - 1);
        }
        return bt(i, j + 1, n, ans);
    }

    private String buildRow(int j, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i == j ? 'Q' : '.');
        }
        return sb.toString();
    }

    private boolean check(int j, List<String> ans) {
        int offset = ans.size();
        for (String row : ans) {
            if (row.charAt(j) == 'Q') {
                return false;
            }
            if (j + offset < row.length() && row.charAt(j + offset) == 'Q') {//右上角
                return false;
            }
            if (j - offset >= 0 && row.charAt(j - offset) == 'Q') {//左上角
                return false;
            }
            offset--;
        }
        return true;
    }
}

