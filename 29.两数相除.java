/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 *
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (18.44%)
 * Likes:    139
 * Dislikes: 0
 * Total Accepted:    14.5K
 * Total Submissions: 78.4K
 * Testcase Example:  '10\n3'
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 
 * 说明:
 * 
 * 
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0;
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;
        int c = b;

        if (a > b) {
            return 0;
        }

        while (true) {

            if (a == b) {
                result = 1;
                break;
            }

            if (b == -1) {
                if (dividend == Integer.MIN_VALUE && divisor == -1) {//溢出
                    return Integer.MAX_VALUE;
                }
                result = -a;
                break;
            }


            if (a < (c << 1) && (c << 1) < 0) {
                c = c << 1;
                result = result == 0 ? 1 : result;
                result = result << 1;
            } else {
                c = c == b ? 0 : c;
                a = a - b;
                if (a > c) {
                    break;
                }
                result++;
            }


        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        }

        return -result;
    }
}

