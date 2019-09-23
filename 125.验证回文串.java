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
        char[] cs = s.toLowerCase().toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char c1 = cs[start];
            while (!((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z') || (c1 >= '0' && c1 <= '9'))) {
                start++;
                if (start == end) {
                    return true;
                }
                c1 = cs[start];
            }
            char c2 = cs[end];
            while (!((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z') || (c2 >= '0' && c2 <= '9'))) {
                end--;
                if (start == end) {
                    return true;
                }
                c2 = cs[end];
            }
            if (c1 != c2) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

