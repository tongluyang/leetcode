/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (39.65%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    4.5K
 * Total Submissions: 11.1K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回符合要求的最少分割次数。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i - 1;
        }
        for (int i = 0; i < chars.length; i++) {
            int offset = 0;
            //奇数，两边扩展
            while (i - offset >= 0 && i + offset < chars.length && isPalindrome(chars, i - offset, i + offset)) {
                dp[i + offset + 1] = Math.min(dp[i + offset + 1], dp[i - offset] + 1);
                offset++;
            }
            offset = 1;
            //偶数，两边扩展
            while (i - offset + 1 >= 0 && i + offset < chars.length && isPalindrome(chars, i - offset + 1, i + offset)) {
                dp[i + offset + 1] = Math.min(dp[i + offset + 1], dp[i - offset + 1] + 1);
                offset++;
            }
        }
        return dp[s.length()];
    }

    private boolean isPalindrome(char[] cs, int start, int end) {
        while (start < end) {
            if (cs[start] != cs[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end

