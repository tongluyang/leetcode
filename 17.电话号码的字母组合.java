/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (49.38%)
 * Likes:    344
 * Dislikes: 0
 * Total Accepted:    27.8K
 * Total Submissions: 56.2K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */
class Solution {
    List<String> ans = new ArrayList<>();
    String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        bt(0, digits, new StringBuilder());
        return ans;
    }

    private void bt(int idx, String digits, StringBuilder str) {
        if (digits.length() == idx) {
            ans.add(str.toString());
            return;
        }
        for (char c : strs[digits.charAt(idx) - '2'].toCharArray()) {
            bt(idx + 1, digits, new StringBuilder(str).append(c));
        }
    }
}
