/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (46.32%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    13.5K
 * Total Submissions: 28K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int u2 = res[p2] * 2;
            int u3 = res[p3] * 3;
            int u5 = res[p5] * 5;
            res[i] = Math.min(u2, Math.min(u3, u5));
            while (res[p2] * 2 <= res[i]) {
                p2++;
            }
            while (res[p3] * 3 <= res[i]) {
                p3++;
            }
            while (res[p5] * 5 <= res[i]) {
                p5++;
            }
        }
        return res[n - 1];
    }
}
// @lc code=end

