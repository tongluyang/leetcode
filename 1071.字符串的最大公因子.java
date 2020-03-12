/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 *
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/description/
 *
 * algorithms
 * Easy (49.90%)
 * Likes:    77
 * Dislikes: 0
 * Total Accepted:    11.5K
 * Total Submissions: 20.4K
 * Testcase Example:  '"ABCABC"\n"ABC"'
 *
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 
 * 
 * 示例 2：
 * 
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 
 * 
 * 示例 3：
 * 
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        char[] gcdChars = new char[minLen];
        int count = 0;
        int p = 0;
        while (p < minLen) {
            char c1 = str1.charAt(p);
            char c2 = str2.charAt(p);
            if (c1 != c2) {
                break;
            }
            gcdChars[p] = c1;
            p++;
            count++;
        }
        if (count == 0) {
            return "";
        }
        // gcdChars目前为最长公共前缀
        while (!check(str1, gcdChars, count) || !check(str2, gcdChars, count)) {
            count--;
            if (count == 0) {
                return "";
            }
        }
        return new String(gcdChars, 0, count);
    }

    private boolean check(String str, char[] chars, int length) {
        if (str.length() % length != 0) {
            return false;
        }
        int count = 1;
        int offset = length;
        while (offset < str.length()) {
            for (int i = 0; i < length; i++) {
                if (str.charAt(offset + i) != chars[i]) {
                    return false;
                }
            }
            count++;
            offset = length * count;
        }
        return true;
    }
}
// @lc code=end

