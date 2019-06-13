/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (42.78%)
 * Likes:    313
 * Dislikes: 0
 * Total Accepted:    36.2K
 * Total Submissions: 84.6K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * 
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        final Map<Integer, List<Character>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int row = Math.abs(Math.abs((i + i / (numRows * 2 - 2)) % (numRows * 2 - 1) - (numRows - 1)) - (numRows - 1));
            List<Character> characters = map.computeIfAbsent(row, k -> new ArrayList<>());
            characters.add(s.charAt(i));
        }

        final StringBuilder sb = new StringBuilder();

        for (Integer integer : map.keySet()) {
            final List<Character> characters = map.get(integer);
            characters.forEach(sb::append);
        }

        return sb.toString();
    }
}

