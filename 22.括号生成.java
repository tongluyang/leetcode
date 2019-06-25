/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (70.47%)
 * Likes:    406
 * Dislikes: 0
 * Total Accepted:    26K
 * Total Submissions: 36.9K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        bt(list, "", 0, 0, n);
        return list;
    }

    public void bt(List<String> list, String cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            list.add(cur);
            return;
        }

        if (left < n) {
            bt(list, cur + "(", left + 1, right, n);
        }
        if (right < left) {
            bt(list, cur + ")", left, right + 1, n);
        }
    }
}

