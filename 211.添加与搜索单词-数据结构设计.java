/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 *
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (38.80%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    5.1K
 * Total Submissions: 12.6K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * 设计一个支持以下两种操作的数据结构：
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * 
 * 示例:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * 说明:
 * 
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * 
 */

// @lc code=start
class WordDictionary {
    private Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }

    public static class Trie {
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
            return search(word, 0);
        }

        private boolean search(String word, int i) {
            if (word.length() <= i) {
                return end;
            }

            int c = word.charAt(i);
            if (c == '.') {
                for (int idx = 0; idx < 26; idx++) {
                    Trie trie = next[idx];
                    if (trie == null) {
                        continue;
                    }
                    if (trie.search(word, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                Trie trie = next[c - 'a'];
                if (trie == null) {
                    return false;
                }
                return trie.search(word, i + 1);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

