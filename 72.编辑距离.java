/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 *
 * https://leetcode-cn.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (53.28%)
 * Likes:    278
 * Dislikes: 0
 * Total Accepted:    10.1K
 * Total Submissions: 19K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 * 
 * 示例 1:
 * 
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释: 
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 
 * 
 * 示例 2:
 * 
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释: 
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 
 * 
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[] dp = new int[w2.length + 1];
        for (int i = 0; i < w2.length; i++) {
            dp[i + 1] = i + 1;
        }
        int pre = 0;
        for (int i = 0; i < w1.length; i++) {
            for (int j = 0; j < w2.length; j++) {
                if (j == 0) {
                    pre = dp[0];
                    dp[0] = i + 1;
                }
                if (w1[i] == w2[j]) {
                    int tmp = dp[j + 1];
                    dp[j + 1] = pre;
                    pre = tmp;
                } else {
                    int tmp = dp[j + 1];
                    dp[j + 1] = Math.min(Math.min(dp[j + 1], dp[j]), pre) + 1;
                    pre = tmp;
                }

            }
        }
        return dp[w2.length];
    }
}

