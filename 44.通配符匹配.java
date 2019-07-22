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
        Boolean[][] mem = new Boolean[s.length() + 1][p.length() + 1];
        return bt(s, p, 0, 0, mem);
    }

    public boolean bt(String s, String p, int si, int pi, Boolean[][] mem) {
        if (s.length() - 1 < si && p.length() - 1 < pi) {//字符串和匹配字符串都正好结束，正确匹配
            return true;
        }
        if (p.length() == pi) {//匹配字符串超长，匹配失败
            return false;
        }
        if (mem[si][pi] != null) {//已经计算，直接返回
            return mem[si][pi];
        }
        
        boolean result = false;
        if (s.length() - 1 >= si) {//字符串未匹配完
            if (p.charAt(pi) == '*') {
                if (bt(s, p, si + 1, pi, mem)) {//贪婪，先吃掉字符串，成功后结束，否则再吐出，匹配字符串加一尝试
                    result = true;
                } else {
                    result = bt(s, p, si, pi + 1, mem);
                }
            } else if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
                result = bt(s, p, si + 1, pi + 1, mem);
            }
        } else if (p.charAt(pi) == '*') {//字符串已匹配完，但匹配字符是*，继续
            result = bt(s, p, si, pi + 1, mem);
        }

        mem[si][pi] = result;
        
        return result;
    }
}

