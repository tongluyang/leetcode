/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 *
 * https://leetcode-cn.com/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (61.76%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    27.7K
 * Total Submissions: 44.8K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 
 * 输出：
 * e
 * 
 * 解释：
 * 'e' 是那个被添加的字母。
 * 
 * 
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        int len = s.length();
        char ans = 0;
        for (int i = 0; i < len; i++) {
            ans -= s.charAt(i);
            ans += t.charAt(i);
        }
        ans += t.charAt(len);
        return ans;
    }
}
// @lc code=end

