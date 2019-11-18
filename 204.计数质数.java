/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.27%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    32.8K
 * Total Submissions: 105.9K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] p = new boolean[n];
        Arrays.fill(p, true);
        int v = 2;
        double sqrt = Math.sqrt(n);
        while (v < sqrt) {
            int multi = 2;
            for (int i = v * 2; i < p.length; i = v * (multi++)) {
                p[i] = false;
            }
            for (int i = v + 1; i < p.length; i++) {
                if (p[i]) {
                    v = i;
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < p.length; i++) {
            if (p[i]) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

