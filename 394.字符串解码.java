/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 *
 * https://leetcode-cn.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (50.07%)
 * Likes:    306
 * Dislikes: 0
 * Total Accepted:    33.1K
 * Total Submissions: 64.7K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 示例:
 * 
 * 
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 
 * 
 */

// @lc code=start
class Solution {
    int p = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (p < s.length()) {
            if (s.charAt(p) >= '0' && s.charAt(p) <= '9') {//count
                int count = 0;
                while (s.charAt(p) >= '0' && s.charAt(p) <= '9') {
                    count = count * 10 + s.charAt(p++) - '0';
                }
                //s.charAt(p) == '['
                p++;
                String str = decodeString(s);
                for (int i = 0; i < count; i++) {
                    sb.append(str);
                }
            } else if (s.charAt(p) == ']') {
                p++;
                return sb.toString();
            } else {
                sb.append(s.charAt(p++));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

