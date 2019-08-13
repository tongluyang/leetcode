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
        int min = Integer.MAX_VALUE;
        String result = "";

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

            while (isMatch(need, cur)) {
                if (min > right - left) {
                    min = right - left;
                    result = s.substring(left, right);
                }

                if (need.containsKey(sa[left])) {
                    cur.put(sa[left], cur.getOrDefault(sa[left], 0) - 1);
                    left++;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

    private boolean isMatch(Map<Character, Integer> need, Map<Character, Integer> cur) {
        if (need.size() != cur.size()) {
            return false;
        }

        return need.keySet().stream().map(key -> cur.get(key) >= need.get(key)).reduce((b1, b2) -> b1 && b2).get();
    }
}

