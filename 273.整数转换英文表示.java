/*
 * @lc app=leetcode.cn id=273 lang=java
 *
 * [273] 整数转换英文表示
 *
 * https://leetcode-cn.com/problems/integer-to-english-words/description/
 *
 * algorithms
 * Hard (23.27%)
 * Likes:    41
 * Dislikes: 0
 * Total Accepted:    2.8K
 * Total Submissions: 10.9K
 * Testcase Example:  '123'
 *
 * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 2^31 - 1 。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 
 * 示例 3:
 * 
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * 示例 4:
 * 
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven
 * Thousand Eight Hundred Ninety One"
 * 
 */

// @lc code=start
class Solution {
    public String numberToWords(int num) {
        return trans0_999_999_999_999(num);
    }
    private String trans0_20(int num) {
        String[] arr = new String[]{
                "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        return arr[num];
    }
    private String trans0_99(int num) {
        if (num < 20) {
            return trans0_20(num);
        }
        String[] arr = new String[]{
                "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        return arr[num / 10] + (num % 10 == 0 ? "" : " " + trans0_20(num % 10));
    }
    private String trans0_999(int num) {
        final int h = num / 100;
        if (h == 0) {
            return trans0_99(num);
        }
        return trans0_20(h) + " Hundred" + (num % 100 == 0 ? "" : " " + trans0_99(num % 100));
    }
    private String trans0_999_999(int num) {
        final int t = num / 1000;
        if (t == 0) {
            return trans0_999(num);
        }
        return trans0_999(t) + " Thousand" + (num % 1000 == 0 ? "" : " " + trans0_999(num % 1000));
    }
    private String trans0_999_999_999(int num) {
        final int m = num / 1_000_000;
        if (m == 0) {
            return trans0_999_999(num);
        }
        return trans0_999(m) + " Million" + (num % 1_000_000 == 0 ? "" : " " + trans0_999_999(num % 1_000_000));
    }
    private String trans0_999_999_999_999(int num) {
        final int b = num / 1_000_000_000;
        if (b == 0) {
            return trans0_999_999_999(num);
        }
        return trans0_999(b) + " Billion" + (num % 1_000_000_000 == 0 ? "" : " " + trans0_999_999_999(num % 1_000_000_000));
    }
}
// @lc code=end

