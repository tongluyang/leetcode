/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 *
 * https://leetcode-cn.com/problems/remove-duplicate-letters/description/
 *
 * algorithms
 * Hard (37.91%)
 * Likes:    114
 * Dislikes: 0
 * Total Accepted:    8K
 * Total Submissions: 21.2K
 * Testcase Example:  '"bcabc"'
 *
 * 
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: "bcabc"
 * 输出: "abc"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * 
 * 
 * 
 * 注意：该题与 1081
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 相同
 * 
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {//前一个大，看后面还有没有前面这个字符，如果后面还有，前面这个就不要了
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.add(c);
        }
        final StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();
    }
}
// @lc code=end

