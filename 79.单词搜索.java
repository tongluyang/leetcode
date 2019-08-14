/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (38.49%)
 * Likes:    176
 * Dislikes: 0
 * Total Accepted:    15.9K
 * Total Submissions: 41.2K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        if (board[0].length == 0) {
            return false;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    char tmp = board[row][col];
                    board[row][col] = 0;
                    if (exist(board, word, row, col, 0, 1)) {
                        return true;
                    }
                    board[row][col] = tmp;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int row, int col, int direction, int length) {
        if (length == word.length()) {
            return true;
        }

        boolean result = false;
        if (direction != 2 && col + 1 < board[0].length && board[row][col + 1] == word.charAt(length)) {
            char tmp = board[row][col + 1];
            board[row][col + 1] = 0;
            result = exist(board, word, row, col + 1, 4, length + 1);
            board[row][col + 1] = tmp;
        }

        if (!result) {
            if (direction != 3 && row + 1 < board.length && board[row + 1][col] == word.charAt(length)) {
                char tmp = board[row + 1][col];
                board[row + 1][col] = 0;
                result = exist(board, word, row + 1, col, 1, length + 1);
                board[row + 1][col] = tmp;
            }
        }
        if (!result) {
            if (direction != 4 && col - 1 >= 0 && board[row][col - 1] == word.charAt(length)) {
                char tmp = board[row][col - 1];
                board[row][col - 1] = 0;
                result = exist(board, word, row, col - 1, 2, length + 1);
                board[row][col - 1] = tmp;
            }
        }
        if (!result) {
            if (direction != 1 && row - 1 >= 0 && board[row - 1][col] == word.charAt(length)) {
                char tmp = board[row - 1][col];
                board[row - 1][col] = 0;
                result = exist(board, word, row - 1, col, 3, length + 1);
                board[row - 1][col] = tmp;
            }
        }
        return result;
    }
}

