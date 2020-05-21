/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (54.72%)
 * Likes:    247
 * Dislikes: 0
 * Total Accepted:    28.5K
 * Total Submissions: 52K
 * Testcase Example:  '1\n2'
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 
 * 示例 1:
 * 
 * 输入: a = 1, b = 2
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: a = -2, b = 3
 * 输出: 1
 * 
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        int flag = 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a & (1 << i)) >> i;
            int bitB = (b & (1 << i)) >> i;
            sum |= ((bitA ^ bitB) ^ flag) << i;
            flag = flag == 0 ? (bitA & bitB) : (bitA | bitB);
        }
        return sum;
    }
}
// @lc code=end

