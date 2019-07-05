/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 *
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (53.95%)
 * Likes:    157
 * Dislikes: 0
 * Total Accepted:    28.4K
 * Total Submissions: 52.5K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 
 * 
 * 上图是一个部分填充的有效的数独。
 * 
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * ⁠    但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 
 * 说明:
 * 
 * 
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            if (!check(row)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            char[] col = new char[9];
            for (int j = 0; j < 9; j++) {
                col[j] = board[j][i];
            }
            if (!check(col)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            char[] block = new char[9];
            for (int j = 0; j < 3; j++) {
                block[0] = board[i * 3][j * 3];
                block[1] = board[i * 3][j * 3 + 1];
                block[2] = board[i * 3][j * 3 + 2];
                block[3] = board[i * 3 + 1][j * 3];
                block[4] = board[i * 3 + 1][j * 3 + 1];
                block[5] = board[i * 3 + 1][j * 3 + 2];
                block[6] = board[i * 3 + 2][j * 3];
                block[7] = board[i * 3 + 2][j * 3 + 1];
                block[8] = board[i * 3 + 2][j * 3 + 2];

                if (!check(block)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[] chars) {
        boolean[] booleans = new boolean[9];
        for (char c : chars) {
            if (c == '.') {
                continue;
            }
            if (booleans[c - 48 - 1]) {
                return false;
            }
            booleans[c - 48 - 1] = true;
        }
        return true;
    }
}

