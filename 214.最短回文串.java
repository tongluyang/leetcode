/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 *
 * https://leetcode-cn.com/problems/shortest-palindrome/description/
 *
 * algorithms
 * Hard (31.28%)
 * Likes:    90
 * Dislikes: 0
 * Total Accepted:    4.3K
 * Total Submissions: 14K
 * Testcase Example:  '"aacecaaa"'
 *
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * 
 * 示例 1:
 * 
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * 
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String r = new StringBuilder(s).reverse().toString();
        String tmp = s + "#" + r;
        int[] f = new int[tmp.length()];
        int t;
        for (int i = 1; i < tmp.length(); i++) {
            t = f[i - 1];
            while (t > 0 && tmp.charAt(i) != tmp.charAt(t)) {
                t = f[t - 1];
            }
            if (tmp.charAt(i) == tmp.charAt(t)) {
                t++;
            }
            f[i] = t;
        }
        return new StringBuffer(s.substring(f[tmp.length() - 1])).reverse().append(s).toString();
    }
}
// @lc code=end

