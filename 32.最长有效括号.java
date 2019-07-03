/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (27.27%)
 * Likes:    254
 * Dislikes: 0
 * Total Accepted:    12.9K
 * Total Submissions: 47.2K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> left = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
                map.put(i, 0);
            } else if (c == ')') {
                if (left.empty()) {
//                    max = max > result ? max : result;
//                    result = 0;
                } else {
                    Integer startIndex = left.pop();
//                    result = result + 2;
                    map.put(startIndex, i - startIndex + 1);
                }
            }
        }


        List<Integer> reducedList = new ArrayList<>();

        for (Integer index : map.keySet()) {
            if (reducedList.contains(index)) {
                continue;
            }
            while (true) {
                Integer value = map.get(index);

                if (value != 0 && map.keySet().contains(index + value) && map.get(index + value) > 0) {
                    map.put(index, value + map.get(index + value));
                    reducedList.add(index + value);
                } else {
                    break;
                }
            }
        }

        return map.values().stream().max(Integer::compareTo).orElse(0);

    }
}

