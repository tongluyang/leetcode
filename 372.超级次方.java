/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 *
 * https://leetcode-cn.com/problems/super-pow/description/
 *
 * algorithms
 * Medium (40.80%)
 * Likes:    60
 * Dislikes: 0
 * Total Accepted:    4.5K
 * Total Submissions: 11.2K
 * Testcase Example:  '2\n[3]'
 *
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 
 * 示例 1:
 * 
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 
 * 
 * 示例 2:
 * 
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 * 
 */

// @lc code=start
class Solution {
    int base = 1337;
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1) % base;
    }
    
    private int superPow(int a, int[] b, int i) {
        // a ^ 1234 = (a ^ 1230) * (a ^ 4) = ((a ^ 123) ^ 10) * (a ^ 4)
        if (i < 0) {
            return 1;
        }
        return myPow(superPow(a, b, i - 1), 10) % base * myPow(a, b[i]);
    }

    private int myPow(int a, int b) {
        a %= base;
        int res = 1;
        for (int i = 0; i < b; i++) {
            res = (res * a) % base;
        }
        return res;
    } 
}
// @lc code=end

