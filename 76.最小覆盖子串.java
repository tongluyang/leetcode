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
        //[p0, p1)
        int p0 = 0;
        int p1 = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        for (char c : map.keySet()) {
            window.put(c, 0);
        }

        int count = 0;
        String min = "";
        while (p1 < s.length()) {
            char c = s.charAt(p1);
            if (!map.containsKey(c)) {//非目标字符
                p1++;
                continue;
            }
            //记录匹配的数量
            window.put(c, window.get(c) + 1);
            if (window.get(c) <= map.get(c)) {//如果没有多余的字符，记录加一，用于后续判断是否都找全了
                count++;
            }
            if (count == t.length()) {//全找到了
                //左指针右移，吐出字符
                while (true) {
                    char left = s.charAt(p0);
                    if (window.containsKey(left)) {
                        // 吐之前，先把字符串提取出来
                        int len = p1 + 1 - p0;
                        if (min.equals("") || min.length() > len) {
                            min = s.substring(p0, p1 + 1);
                        }
                        window.put(left, window.get(left) - 1);

                        if (window.get(left) < map.get(left)) {
                            count--;
                            p0++;
                            break;
                        }
                    }
                    p0++;
                }
            }
            p1++;
        }
        return min;
    }
}

