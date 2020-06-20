/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (40.52%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    53.4K
 * Total Submissions: 130.1K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char a = s.charAt(l);
            if (!isValid(a)) {
                l++;
                continue;
            }
            char b = s.charAt(r);
            if (!isValid(b)) {
                r--;
                continue;
            }
            a = toUpper(a);
            b = toUpper(b);
            if (a != b) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    private char toUpper(char c) {
        if (c >= 'a') {
            c -= 'a' - 'A';
        }
        return c;
    }
    
    private boolean isValid(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}

