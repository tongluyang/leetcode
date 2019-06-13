/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (32.49%)
 * Likes:    1087
 * Dislikes: 0
 * Total Accepted:    133.4K
 * Total Submissions: 410.4K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */
import java.math.BigDecimal;

class Solution {
    public int reverse(int x) {
        String s = Math.abs(x) + "";
        final int length = s.length();
        BigDecimal result = new BigDecimal(0);
        for (int i = 0; i < length; i++) {
            result = result.add(new BigDecimal(s.charAt(i) - 48).multiply(new BigDecimal(1).movePointRight(i)));
        }
        if (x < 0) {
            result = result.multiply(new BigDecimal(-1));
        }
        if (result.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
            return 0;
        }
        if (result.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0) {
            return 0;
        }
        return result.intValue();
    }
}

