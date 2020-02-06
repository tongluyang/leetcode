/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 *
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (45.02%)
 * Likes:    97
 * Dislikes: 0
 * Total Accepted:    5.2K
 * Total Submissions: 11.6K
 * Testcase Example:  '"()())()"'
 *
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * 
 * 示例 1:
 * 
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 
 * 
 * 示例 2:
 * 
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 
 * 
 * 示例 3:
 * 
 * 输入: ")("
 * 输出: [""]
 * 
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        s = prepare(s);
        if (isValid(s)) {
            return Collections.singletonList(s);
        }
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean exists = false;
            for (int x = 0; x < size; x++) {
                String str = queue.poll();
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                        continue;
                    }
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    String newStr = str.substring(0, i) + str.substring(i + 1, str.length());
                    if (!newStr.equals(prepare(newStr))) {
                        continue;
                    }
                    boolean valid = isValid(newStr);
                    exists = exists || valid;
                    if (valid) {
                        set.add(newStr);
                    }
                    if (!queue.contains(newStr)) {
                        queue.add(newStr);
                    }
                }
            }
            if (exists) {
                break;
            }
        }
        if (set.size() == 0) {
            return Collections.singletonList("");
        }
        return new ArrayList<>(set);
    }

    private String prepare(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                break;
            }
            if (s.charAt(i) == ')') {
                s = s.substring(0, i) + s.substring(i + 1, s.length());
                i--;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                break;
            }
            if (s.charAt(i) == '(') {
                s = s.substring(0, i) + s.substring(i + 1, s.length());
            }
        }
        return s;
    }

    private boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        for (char c : chars) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
                if (left < 0) {
                    return false;
                }
            }
        }
        return left == 0;
    }
}
// @lc code=end

