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
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> strings = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return strings;
        }

        strings.add("");
        for (char c : digits.toCharArray()) {
            final String s = map.get(c - 48);
            strings = join(strings, s.toCharArray());
        }

        return strings;
    }

    public List<String> join(List<String> ss, char[] cs) {
        final ArrayList<String> list = new ArrayList<>();
        for (String s : ss) {
            for (char c : cs) {
                list.add(String.join("", s, String.valueOf(c)));
            }
        }
        return list;
    }
}

