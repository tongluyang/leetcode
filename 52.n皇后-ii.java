/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 *
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (73.70%)
 * Likes:    59
 * Dislikes: 0
 * Total Accepted:    6.9K
 * Total Submissions: 9.2K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] single = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                single[i][j] = '.';
            }
        }
        solveNQueens(result, single, n, 0);
        return result.size();
    }

    public void solveNQueens(List<List<String>> result, char[][] single, int n, int row) {
        if (n < row + 1) {
            List<String> s = new ArrayList<>();
            for (char[] chars : single) {
                s.add(String.valueOf(chars));
            }
            result.add(s);
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < row; j++) {
                flag = flag && single[j][i] == '.' && (i + (row - j) >= n || single[j][i + (row - j)] == '.') && (i - (row - j) < 0 || single[j][i - (row - j)] == '.');
            }
            if (flag) {
                single[row][i] = 'Q';
                solveNQueens(result, single, n, row + 1);
                single[row][i] = '.';
            }
        }
    }
}

