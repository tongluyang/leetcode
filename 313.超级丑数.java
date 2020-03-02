/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 *
 * https://leetcode-cn.com/problems/super-ugly-number/description/
 *
 * algorithms
 * Medium (61.12%)
 * Likes:    64
 * Dislikes: 0
 * Total Accepted:    5.5K
 * Total Submissions: 9K
 * Testcase Example:  '12\n[2,7,13,19]'
 *
 * 编写一段程序来查找第 n 个超级丑数。
 * 
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32 
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12
 * 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 
 * 说明:
 * 
 * 
 * 1 是任何给定 primes 的超级丑数。
 * 给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        int[] p = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int u = res[p[j]] * primes[j];
                if (u < min) {
                    min = u;
                }
            }
            res[i] = min;
            for (int j = 0; j < primes.length; j++) {
                int u = res[p[j]] * primes[j];
                if (u <= min) {
                    p[j]++;
                }
            }
        }
        return res[n - 1];
    }
}
// @lc code=end

