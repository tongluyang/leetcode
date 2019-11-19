/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (59.96%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    16K
 * Total Submissions: 25.6K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {
    private boolean end = false;
    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, 0);
    }

    private void insert(String word, int i) {
        if (word.length() <= i) {
            end = true;
            return;
        }
        int index = word.charAt(i);
        Trie trie = next[index - 'a'];
        if (trie == null) {
            trie = new Trie();
            next[index - 'a'] = trie;
        }
        trie.insert(word, i + 1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, 0, false);
    }

    private boolean search(String word, int i, boolean isStartWith) {
        if (word.length() <= i) {
            if (isStartWith) {
                return true;
            }
            return end;
        }

        int index = word.charAt(i);
        Trie trie = next[index - 'a'];
        if (trie == null) {
            return false;
        }
        return trie.search(word, i + 1, isStartWith);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(prefix, 0, true);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

