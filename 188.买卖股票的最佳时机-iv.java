/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (28.19%)
 * Likes:    123
 * Dislikes: 0
 * Total Accepted:    7.2K
 * Total Submissions: 26K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4
 * 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int max = 0;
        if (k >= prices.length / 2) {//贪心
            boolean exists = false;
            for (int i = 0; i < prices.length; i++) {
                if (!exists) {
                    if (i < prices.length - 1 && prices[i + 1] > prices[i]) {//还有机会卖并且明天涨，那么今天买
                        exists = true;
                        max = max - prices[i];
                    }
                } else {
                    if (i == prices.length - 1 || prices[i + 1] < prices[i]) {
                        exists = false;
                        max = max + prices[i];
                    }
                }
            }
            return max;
        }
        int[][][] dp = new int[2]//是否持仓，1持仓，0空仓
                [k + 1]//交易次数，包括0和最大次数，所以k+1
                [prices.length];//第n天的利润，n从0开始
        for (int i = 1; i <= k; i++) {//交易次数，交易次数为0，利润肯定为0，不需要计算，直接用默认值参与后面的计算
            for (int j = 0; j < prices.length; j++) {
                if (j == 0) {//第0天，只能买入或空仓，不能卖出，空仓利润为0，默认
                    dp[1][i][j] = -prices[j];
                    continue;
                }
                dp[1][i][j] = Math.max(dp[0][i - 1][j - 1] - prices[j], dp[1][i][j - 1]);// 买入或持有不动
                dp[0][i][j] = Math.max(dp[1][i][j - 1] + prices[j], dp[0][i][j - 1]);//卖出或空仓不动
                max = Math.max(max, dp[0][i][j]);
            }
        }
        return max;
    }
}
// @lc code=end

