/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 *
 * https://leetcode-cn.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (39.49%)
 * Likes:    169
 * Dislikes: 0
 * Total Accepted:    19.9K
 * Total Submissions: 50K
 * Testcase Example:  '"2"\n"3"'
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 
 * 说明：
 * 
 * 
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        StringBuilder result = new StringBuilder("0");
        for (int i = num2.toCharArray().length - 1; i >= 0; i--) {
            StringBuilder s = new StringBuilder();
            int[] r = new int[2];
            int c2 = num2.charAt(i);
            for (int j = num1.toCharArray().length - 1; j >= 0; j--) {
                int c1 = num1.charAt(j);

                multiply1(c1 - 48, c2 - 48, r);
                s.insert(0, r[1]);
            }
            if (r[0] > 0) {
                s.insert(0, r[0]);
            }

            for (int i1 = 0; i1 < num2.length() - 1 - i; i1++) {
                s.append("0");
            }

            result = add(result.toString(), s.toString());

        }

        return result.toString();
    }

    public StringBuilder add(String a, String b) {
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int flag = 0;
        StringBuilder s = new StringBuilder();
        while (true) {
            if (ai < 0 && bi < 0) {
                if (flag > 0) {
                    s.insert(0, flag);
                }
                break;
            }

            int a1 = 0;
            int a2 = 0;
            if (ai >= 0) {
                a1 = a.charAt(ai) - 48;
            }
            if (bi >= 0) {
                a2 = b.charAt(bi) - 48;
            }

            int r = a1 + a2 + flag;
            if (r >= 10) {
                flag = 1;
                r = r % 10;
            } else {
                flag = 0;
            }

            s.insert(0, r);

            ai--;
            bi--;
        }

        return s;
    }

    public void multiply1(int a, int b, int[] r) {
        int x = a * b;
        r[1] = x % 10 + r[0];
        r[0] = x / 10;
        if (r[1] >= 10) {
            r[1] = r[1] % 10;
            r[0] = r[0] + 1;
        }

    }
}

