/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 *
 * https://leetcode-cn.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (37.29%)
 * Likes:    86
 * Dislikes: 0
 * Total Accepted:    4.8K
 * Total Submissions: 13.2K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * 
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        return check(c1, c2, c3, 0, 0, 0);
    }

    private boolean check(char[] c1, char[] c2, char[] c3, int a, int b, int x) {
        if (x >= c3.length) {
            return true;
        }
        if (a < c1.length && c3[x] == c1[a]) {
            if (check(c1, c2, c3, a + 1, b, x + 1)) {
                return true;
            }
        }
        if (b < c2.length && c3[x] == c2[b]) {
            return check(c1, c2, c3, a, b + 1, x + 1);
        }
        return false;
    }
}

