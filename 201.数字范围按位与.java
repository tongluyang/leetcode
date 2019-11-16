/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 *
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/description/
 *
 * algorithms
 * Medium (41.41%)
 * Likes:    62
 * Dislikes: 0
 * Total Accepted:    5.8K
 * Total Submissions: 13.3K
 * Testcase Example:  '5\n7'
 *
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 
 * 示例 1: 
 * 
 * 输入: [5,7]
 * 输出: 4
 * 
 * 示例 2:
 * 
 * 输入: [0,1]
 * 输出: 0
 * 
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int minus = n - m;
        if (minus == 0) {
            return m & n;
        }
        int h = 0;
        for (int i = 1; i < 32; i++) {
            if (m >> i == 0) {
                if (n >> i != 0) {
                    return 0;
                }
                h = i;
                break;
            }
        }
        int l = 0;
        for (int i = 1; i < 32; i++) {
            if (minus >> i == 0) {
                l = i;
                break;
            }
        }
        int tmp = 0;
        for (int i = l; i < h; i++) {
            tmp += 1 << i;
        }
        return m & n & tmp;
    }
}
// @lc code=end

