/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 *
 * https://leetcode-cn.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (35.24%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    6.2K
 * Total Submissions: 16.6K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例:
 * 
 * 输入: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * 输出: ["eat","oath"]
 * 
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 
 * 提示:
 * 
 * 
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        int row = board.length;
        if (row == 0) {
            return result;
        }
        int col = board[0].length;
        if (col == 0) {
            return result;
        }
        Tire tire = new Tire();
        for (String word : words) {
            tire.insert(word);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                findWord(board, tire, "", i, j, set);
            }
        }
        return new ArrayList<>(set);
    }


    private void findWord(char[][] board, Tire tire, String parent, int i, int j, Set<String> set) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return;
        }
        if (tire.size == 0) {
            return;
        }
        char c = board[i][j];
        if (c == '.') {
            return;
        }
        Tire child = tire.children[c - 'a'];
        if (child != null) {
            if (child.end) {
                set.add(child.str);
            }
            board[i][j] = '.';
            findWord(board, child, parent, i + 1, j, set);
            findWord(board, child, parent, i - 1, j, set);
            findWord(board, child, parent, i, j + 1, set);
            findWord(board, child, parent, i, j - 1, set);
            board[i][j] = c;
        }
    }

    public static class Tire {
        Tire[] children = new Tire[26];
        boolean end;
        int size = 0;
        String str = "";
        public void insert(String word) {
            insert(word.toCharArray(), 0);
        }

        private void insert(char[] word, int index) {
            if (word.length == index) {
                end = true;
                return;
            }
            Tire tire = children[word[index] - 'a'];
            if (tire == null) {
                tire = new Tire();
                children[word[index] - 'a'] = tire;
                tire.str = new String(word, 0, index + 1);
                size++;
            }
            tire.insert(word, index + 1);
        }
    }
}
// @lc code=end

