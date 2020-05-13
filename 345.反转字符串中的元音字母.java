/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (49.77%)
 * Likes:    87
 * Dislikes: 0
 * Total Accepted:    34.1K
 * Total Submissions: 68.5K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            if (!isVowel(cs[i])) {
                i++;
                continue;
            }
            if (!isVowel(cs[j])) {
                j--;
                continue;
            }
            swap(cs, i++, j--);
        }
        return new String(cs);
    }

    private boolean isVowel(char c) {
         return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
             || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] s, int i, int j) {
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}
// @lc code=end

