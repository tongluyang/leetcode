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
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int p0 = 0;
        int p1 = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (p1 < len) {
            char c = chars[p1];
            if (set.contains(c)) {
                max = Math.max(max, set.size());
                char tmp;
                do {
                    tmp = chars[p0++];
                    set.remove(tmp);
                } while (tmp != c);
            }
            set.add(c);
            p1++;
        }
        max = Math.max(max, set.size());
        return max;
    }
}

