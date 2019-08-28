/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.44%)
 * Likes:    179
 * Dislikes: 0
 * Total Accepted:    13.7K
 * Total Submissions: 63.3K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (dp.length == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int singleEnd = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                if (i == 0 || cs[i - 1] == '0' || cs[i - 1] > '2') {
                    return 0;
                }
                dp[i] = dp[i - 1];
                continue;
            }
            if (i == 0) {
                dp[i] = 1;
                continue;
            }
            if ((cs[i - 1] < '2' || (cs[i - 1] == '2' && cs[i] <= '6')) && cs[i - 1] != '0' && (i >= cs.length - 1 || (i < cs.length - 1 && cs[i + 1] != '0'))) {
                if (i == 1) {
                    singleEnd = 1;
                } else {
                    singleEnd = dp[i - 2];
                }
                dp[i] = dp[i - 1] + singleEnd;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}

