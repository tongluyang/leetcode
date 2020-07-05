/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 *
 * https://leetcode-cn.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (23.50%)
 * Likes:    159
 * Dislikes: 0
 * Total Accepted:    7.2K
 * Total Submissions: 30.3K
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * 
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 
 * 
 * 两个字符串完全匹配才算匹配成功。
 * 
 * 说明:
 * 
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 
 * 
 * 示例 4:
 * 
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 
 * 
 * 示例 5:
 * 
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenP; j++) {
                if (i == 0 && j == 0) {//都是空
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {//pattern空，string不空，肯定不匹配
                    dp[i][j] = false;
                    continue;
                }
                char cp = p.charAt(j - 1);
                if (cp == '*') {
                    boolean flag = false;
                    for (int k = 0; k <= i; k++) {
                        if (dp[k][j - 1]) {
                            flag = true;
                            break;
                        }
                    }
                    dp[i][j] = flag;
                } else if (cp == '?') {
                    dp[i][j] = i == 0 ? false : dp[i - 1][j - 1];
                } else {
                    dp[i][j] = i == 0 ? false : (cp == s.charAt(i - 1) && dp[i - 1][j - 1]);
                }
            }
        }
        return dp[lenS][lenP];
    }
}
