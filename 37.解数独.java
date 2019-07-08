/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 *
 * https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (54.31%)
 * Likes:    171
 * Dislikes: 0
 * Total Accepted:    7.4K
 * Total Submissions: 13.6K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 空白格用 '.' 表示。
 * 
 * 
 * 
 * 一个数独。
 * 
 * 
 * 
 * 答案被标成红色。
 * 
 * Note:
 * 
 * 
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */
class Solution {
    public void solveSudoku(char[][] board) {
        bt(board, 0, '1');
    }

    public boolean bt(char[][] board, int index, char c) {
        if (index >= 81) {
            return true;
        }

        int row = index / 9;
        int col = index % 9;

        if (board[row][col] == '.') {
            for (; c <= '9'; c++) {
                board[row][col] = c;
                boolean isValid = check(getRow(board, index)) && check(getCol(board, index)) && check(getBlock(board, index));
                if (isValid && bt(board, index + 1, '1')) {
                    return true;
                } else {
                    board[row][col] = '.';//恢复原样
                }
            }
        } else {
            return bt(board, index + 1, '1');
        }

        return false;
    }
    public char[] getRow(char[][] board, int index) {
        return board[index / 9];
    }
    public char[] getCol(char[][] board, int index) {
        char[] col = new char[9];
        for (int j = 0; j < 9; j++) {
            col[j] = board[j][index % 9];
        }
        return col;
    }
    public char[] getBlock(char[][] board, int index) {
        char[] block = new char[9];
        int i = index / 9 / 3;
        int j = (index % 9) / 3;
        block[0] = board[i * 3][j * 3];
        block[1] = board[i * 3][j * 3 + 1];
        block[2] = board[i * 3][j * 3 + 2];
        block[3] = board[i * 3 + 1][j * 3];
        block[4] = board[i * 3 + 1][j * 3 + 1];
        block[5] = board[i * 3 + 1][j * 3 + 2];
        block[6] = board[i * 3 + 2][j * 3];
        block[7] = board[i * 3 + 2][j * 3 + 1];
        block[8] = board[i * 3 + 2][j * 3 + 2];
        return block;
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

