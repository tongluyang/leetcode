/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.36%)
 * Likes:    939
 * Dislikes: 0
 * Total Accepted:    65.3K
 * Total Submissions: 257.1K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String longestPalindrome(String s) {
        final int count = getCount(s);
        return getStr(count, s);
    }

    public int getCount(String s) {
        final int max = s.length() / 2;
        int cur = 1;
        for (; cur <= max; cur++) {
            final Pattern pattern = Pattern.compile(buildRegex(cur));
            final Matcher matcher = pattern.matcher(s);
            int start = 0;
            if (!matcher.find(start)) {
                if (cur == 1) {
                    return 0;
                }
                break;
            }
        }
        return cur - 1;
    }

    public String getStr(int count, String s) {
        if (s.length() == 0) {
            return s;
        }
        if (count <= 0) {
            return String.valueOf(s.charAt(0));
        }

        String result = "";
        final Pattern pattern = Pattern.compile(buildRegex(count));
        final Matcher matcher = pattern.matcher(s);
        int start = 0;
        while (matcher.find(start)) {
            String group = matcher.group();

            result = group.length() > result.length() ? group : result;

            start = matcher.start() + 1;
        }
        return result;
    }

    public String buildRegex(int count) {
        StringBuilder regex = new StringBuilder("(");
        for (int i = count; i > 0; i--) {
            regex.append("(.)");
        }
        regex.append(".?");
        for (int i = count; i > 0; i--) {
            regex.append("\\" + (i + 1));
        }
        regex.append(")");
        return regex.toString();
    }
}

