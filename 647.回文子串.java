/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 *
 * https://leetcode-cn.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (64.67%)
 * Likes:    374
 * Dislikes: 0
 * Total Accepted:    61.3K
 * Total Submissions: 94.8K
 * Testcase Example:  '"abc"'
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 
 * 
 * 示例 2：
 * 
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输入的字符串长度不会超过 1000 。
 * 
 * 
 */

// @lc code=start
class Solution {
    int ans = 0;
    public int countSubstrings(String s) {
        int len = s.length();
        Boolean[][] dp = new Boolean[len][len];
        dfs(dp, 0, 0, s);
        return ans;
    }

    private boolean dfs(Boolean[][] dp, int i, int j, String s) {
        if (i > j) {
            return true;
        }
        if (i >= s.length() || j >= s.length()) {
            return false;
        }
        dfs(dp, i, j + 1, s);
        dfs(dp, i + 1, j, s);
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = true;
            ans++;
            return true;
        }
        dp[i][j] = s.charAt(i) == s.charAt(j) && dfs(dp, i + 1, j - 1, s);
        if (dp[i][j]) {
            ans++;
        }
        return dp[i][j];
    }
}
// @lc code=end

