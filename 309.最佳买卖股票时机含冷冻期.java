/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (50.99%)
 * Likes:    216
 * Dislikes: 0
 * Total Accepted:    14.1K
 * Total Submissions: 27.6K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * 
 * 示例:
 * 
 * 输入: [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[2] // 是否持仓，0空仓1持仓
                            [2]   // 是否是冷冻期，0非冷冻期1冷冻期
                            [prices.length]; // 第几天的利润
        dp[0][0][0] = 0; //第一天，空仓
        dp[1][0][0] = -prices[0]; //第一天买入
        for (int i = 1; i < prices.length; i++) {
            //空仓状态
            //没有冻结，有可能是昨天本来就空仓或者昨天清仓
            dp[0][0][i] = Math.max(dp[0][0][i - 1], dp[0][1][i - 1]);
            //冻结，只可能是昨天持仓今天清仓了
            dp[0][1][i] = dp[1][0][i - 1] + prices[i];

            //持仓状态
            //没有冻结，有可能是昨天本来就持仓或者昨天没卖出并且今天买入了
            dp[1][0][i] = Math.max(dp[1][0][i - 1], dp[0][0][i - 1] - prices[i]);
        }
        return Math.max(dp[0][0][prices.length - 1], dp[0][1][prices.length - 1]);
    }
}
// @lc code=end

