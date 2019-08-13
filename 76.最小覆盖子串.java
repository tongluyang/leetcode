/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (36.26%)
 * Likes:    188
 * Dislikes: 0
 * Total Accepted:    8.6K
 * Total Submissions: 23.8K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 
 * 说明：
 * 
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;
        int min = Integer.MAX_VALUE;

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> cur = new HashMap<>();

        for (char c : ta) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < sa.length) {
            if (need.containsKey(sa[right])) {
                cur.put(sa[right], cur.getOrDefault(sa[right], 0) + 1);
            }
            right++;

            boolean certainMatch = false;
            char single = 0;
            while (certainMatch || isMatch(need, cur, single)) {
                if (min > right - left) {
                    min = right - left;
                    minLeft = left;
                    minRight = right;
                }

                if (!need.containsKey(sa[left])) {
                    left++;
                    certainMatch = true;
                    continue;
                }
                certainMatch = false;

                cur.put(sa[left], cur.get(sa[left]) - 1);
                single = sa[left];
                left++;
            }
        }

        return s.substring(minLeft, minRight);
    }

    private boolean isMatch(Map<Character, Integer> need, Map<Character, Integer> cur, char single) {
        if (single > 0) {
            return need.get(single) <= cur.get(single);
        }
        if (need.size() != cur.size()) {
            return false;
        }

        for (Character key : need.keySet()) {
            if (cur.get(key) < need.get(key)) {
                return false;
            }
        }
        return true;
    }
}

