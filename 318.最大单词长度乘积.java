/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 *
 * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (62.62%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    5.9K
 * Total Submissions: 9.4K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j])
 * 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * 
 * 示例 1:
 * 
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16 
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 
 * 示例 2:
 * 
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4 
 * 解释: 这两个单词为 "ab", "cd"。
 * 
 * 示例 3:
 * 
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0 
 * 解释: 不存在这样的两个单词。
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] masks = new int[len];
        int[] lengths = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            masks[i] = mask;
            lengths[i] = word.length();
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    if (lengths[i] * lengths[j] > max) {
                        max = lengths[i] * lengths[j];
                    }
                }
            }
        }
        return max;
    }
}
// @lc code=end

