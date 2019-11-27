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
        int mid = s.length() / 2;
        StringBuilder sb = new StringBuilder(s);
        for (int i = mid; i >= 0; i--) {
            int offset = 0;
            int flag = -1;//奇偶，-1未知 1奇数回文 0或2偶数回文
            while (i - offset - 1 >= 0) {
                if (flag != (s.length() % 2 + 1) && s.charAt(i + offset + s.length() % 2) == s.charAt(i - offset - 1)) {//偶数长度先偶数，奇数长度先奇数
                    offset++;
                    flag = s.length() % 2;
                } else if (flag != (s.length() % 2) && (i + offset + (s.length() % 2 + 1) % 2 < s.length()) &&  s.charAt(i + offset + (s.length() % 2 + 1) % 2) == s.charAt(i - offset - 1)) {
                    offset++;
                    flag = s.length() % 2 + 1;
                } else {
                    break;
                }
            }
            if (i - offset - 1 == -1) {//前指针到第一个字符前
                if (i == 0) {//没有回文，以第一个字符为中心，预备奇数回文
                    flag = 1;
                }
                while (i + offset - 1 + (flag == 1 ? 1 : 0) < s.length() - 1) {
                    sb.insert(0, s.charAt(i + offset++ + (flag == 1 ? 1 : 0)));
                }
                break;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

