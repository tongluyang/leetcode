/*
 * @lc app=leetcode.cn id=837 lang=java
 *
 * [837] 新21点
 *
 * https://leetcode-cn.com/problems/new-21-game/description/
 *
 * algorithms
 * Medium (27.50%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    7.2K
 * Total Submissions: 18.9K
 * Testcase Example:  '10\n1\n10'
 *
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。
 * 每次抽取都是独立的，其结果具有相同的概率。
 * 
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 * 
 * 示例 1：
 * 
 * 输入：N = 10, K = 1, W = 10
 * 输出：1.00000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 
 * 示例 2：
 * 
 * 输入：N = 6, K = 1, W = 10
 * 输出：0.60000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 * 
 * 示例 3：
 * 
 * 输入：N = 21, K = 17, W = 10
 * 输出：0.73278
 * 
 * 提示：
 * 
 * 
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * 如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
 * 此问题的判断限制时间已经减少。
 * 
 * 
 */

// @lc code=start
class Solution {
    public double new21Game(int N, int K, int W) {
        //得分为N的概率为dp[N]
        //抽取一个数，每个数的概率是1/W，假如抽取到的是X
        //这一次的概率是1/W * dp[N - X]
        //整体的概率为所有可能性相加
        //也就是dp[N] = 1/W * dp[N - 1] + 1/W * dp[N - 2] + ... + 1/W * dp[N - W]
        //N - X < 0，概率为0
        //N - X = 0，概率为1
        //N - X >= K，概率为0
        double[] dp = new double[N + 1];
        double[] sum = new double[N + 2];//前项和
        dp[0] = 1;
        sum[0] = 0;
        sum[1] = 1;
        for (int i = 1; i <= N; i++) {
            // for (int x = 1; x <= W; x++) {//x为被抽到的数
            //     if (i - x < 0) {
            //         //概率0，因为分数不会是负数
            //     } else if (i - x >= K) {
            //         //概率0，因为之前分数以及到达K了，不会再抽了
            //     } else {
            //         dp[i] += 1.0 / W * dp[i - x];
            //     }
            // }

            //因为每次i的循环，都是要加连续的dp[i - x]
            //所以可以暂存dp的前缀和，相减就是区间和
            int minX = Math.max(1, i - K + 1);
            int maxX = Math.min(W, i);
            dp[i] = (sum[i - minX + 1] - sum[i - maxX]) * (1.0 / W);
            sum[i + 1] = dp[i] + sum[i];
        }
        double res = 0;
        for (int i = K; i <= N; i++) {
            res += dp[i];
        }
        return res;
    }
}
// @lc code=end

