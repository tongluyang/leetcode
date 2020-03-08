/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (37.12%)
 * Likes:    438
 * Dislikes: 0
 * Total Accepted:    53.1K
 * Total Submissions: 139.5K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3 
 * 解释: 11 = 5 + 5 + 1
 * 
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount + 1]);
    }

    public int coinChange(int[] coins, int amount, int[] mem) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (mem[amount] != 0) {
            return mem[amount];
        }
        int min = -1;
        for (int i = 0; i < coins.length; i++) {
            int count = coinChange(coins, amount - coins[i], mem) + 1;
            if (count != 0 && (min == -1 || count < min)) {
                min = count;
            }
        }
        mem[amount] = min;
        return min;
    }
}
// @lc code=end

