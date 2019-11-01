/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 *
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (24.75%)
 * Likes:    76
 * Dislikes: 0
 * Total Accepted:    5.7K
 * Total Submissions: 22.8K
 * Testcase Example:  '1\n2'
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 
 * 示例 1:
 * 
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 
 * 
 * 示例 2:
 * 
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 
 * 示例 3:
 * 
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (numerator % denominator == 0) {
            return "" + ((long) numerator / denominator);
        }
        int prev = numerator / denominator;
        StringBuilder value = new StringBuilder(prev + ".");

        List<Long> remainders = new ArrayList<>();
        List<Long> quotients = new ArrayList<>();
        long remainder = numerator;
        boolean rec = false;
        int recStart;
        while (true) {
            remainder = remainder % denominator;
            if (remainder == 0) {
                recStart = remainders.indexOf(remainder);
                break;
            }
            if (remainders.contains(remainder)) {
                rec = true;
                recStart = remainders.indexOf(remainder);
                break;
            }
            remainders.add(remainder);
            long quotient = remainder * 10 / denominator;
            remainder = remainder * 10 % denominator;
            quotients.add(quotient);
        }

        for (int i = 0; i < quotients.size(); i++) {
            if (rec && i == recStart) {
                value.append("(");
            }
            value.append(Math.abs(quotients.get(i)));
        }
        if (rec) {
            value.append(")");
        }

        if (((numerator ^ denominator) & 0x80000000) == 0x80000000
                && !value.toString().equals("0") && !value.toString().startsWith("-")) {
            value.insert(0, "-");
        }

//        return numerator + "/" + denominator + "=" + value.toString();
        return value.toString();
    }
}
// @lc code=end

