/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (29.78%)
 * Likes:    1897
 * Dislikes: 0
 * Total Accepted:    134.9K
 * Total Submissions: 452.9K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        int curMax = 0;
        final HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (characters.contains(c)) {
                characters.clear();
                max = max > curMax ? max : curMax;
                curMax = 0;
                start++;
                i = start - 1;

                if (s.length() - start < max) {
                    break;
                }
            } else {
                characters.add(c);
                curMax++;
            }
        }
        max = max > curMax ? max : curMax;

        return max;
    }
}

