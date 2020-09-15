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
    int[] nums = new int[10];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    nums[board[i][j] - '0']++;
                }
            }
        }
        bt(board, 0, '1');
    }

    private boolean bt(char[][] board, int idx, char num) {
        if (num > '9') {
            return false;
        }
        if (idx == 81) {
            return true;
        }
        if (nums[num - '0'] > 9) {
            return false;
        }
        int row = idx / 9;
        int col = idx % 9;
        
        if (board[row][col] != '.') {
            return bt(board, idx + 1, '1');
        }

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return bt(board, idx, (char) (num + 1));
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return bt(board, idx, (char) (num + 1));
            }
        }
        int x = row / 3 * 3;
        int y = col / 3 * 3;
        for (int i = x + 0; i < x + 3; i++) {
            for (int j = y + 0; j < y + 3; j++) {
                if (board[i][j] == num) {
                    return bt(board, idx, (char) (num + 1));
                }
            }
        }
        board[row][col] = num;
        nums[num - '0']++;
        
        if (bt(board, idx + 1, '1')) {
            return true;
        }
        board[row][col] = '.';
        nums[num - '0']--;
        return bt(board, idx, (char) (num + 1));
    }
}

