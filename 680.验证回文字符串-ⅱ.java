/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 *
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (36.66%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    25.4K
 * Total Submissions: 66.7K
 * Testcase Example:  '"aba"'
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "aba"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 
 * 
 * 注意:
 * 
 * 
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s.toCharArray(), 0, s.length() - 1, 1);
    }
    
    private boolean isPalindrome(char[] chars, int i, int j, int count) {
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
                continue;
            }
            if (count > 0) {
                return isPalindrome(chars, i + 1, j, count - 1) || isPalindrome(chars, i, j - 1, count - 1);
            }
            return false;
        }
        return true;
    }
}
// @lc code=end

