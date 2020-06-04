/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有K个重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (42.89%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    10.1K
 * Total Submissions: 23.6K
 * Testcase Example:  '"aaabb"\n3'
 *
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * s = "aaabb", k = 3
 * 
 * 输出:
 * 3
 * 
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * s = "ababbc", k = 2
 * 
 * 输出:
 * 5
 * 
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * 
 * 
 */

// @lc code=start
class Solution {
    int res = 0;
    public int longestSubstring(String s, int k) {
        if (k <= 1) {
            return s.length();
        }
        if (res >= s.length()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String regex = "";
        for (char c : map.keySet()) {
            if (map.get(c) < k) {
                regex += c;
            }
        }
        if ("".equals(regex)) {
            return s.length();
        }
        String[] splits = s.split("[" + regex + "]");
        for (String sub : splits) {
            int longest = longestSubstring(sub, k);
            if (longest > res) {
                res = longest;
            }
        }
        return res;
    }
}
// @lc code=end

