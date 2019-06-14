/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (56.07%)
 * Likes:    619
 * Dislikes: 0
 * Total Accepted:    116.3K
 * Total Submissions: 207.3K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int tmp = 1;
        int i = 0;
        while (x / 10 >= tmp) {
//            System.out.println("compare " + i);
            if (getHigh(x, i) != getLow(x, i)) {
                return false;
            }
            tmp *= 100;
            i++;
        }

        return true;
    }

    private int getLow(int x, int i) {
        for (int i1 = 0; i1 < i; i1++) {
            x = x / 10;
        }
        return x % 10;
    }

    private int getHigh(int x, int i) {
        int tmp = 1;
        for (int i1 = 0; i1 < i; i1++) {
            tmp = tmp * 10;
        }

        while (x >= tmp * 10){
            x = x / 10;
        }
        return x % 10;
    }
}

