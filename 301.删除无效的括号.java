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
        int[] count = getDeleteCount(s);
        List<String> strings = new ArrayList<>(removeInvalidParentheses(s, count[0], count[1], new HashSet<>()));
        return strings.size() == 0 ? Collections.singletonList("") : strings;
    }

    public Set<String> removeInvalidParentheses(String s, int left, int right, Set<String> mem) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                return Collections.singleton(s);
            }
            return Collections.emptySet();
        }

        //先预处理一下，)开头的或(结尾的，肯定要删除
        int originLength = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                break;
            }
            if (s.charAt(i) == ')') {
                s = s.substring(0, i) + s.substring(i + 1, s.length());
                i--;
                right--;
                if (right < 0) {
                    return Collections.emptySet();
                }
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                break;
            }
            if (s.charAt(i) == '(') {
                s = s.substring(0, i) + s.substring(i + 1, s.length());
                left--;
                if (left < 0) {
                    return Collections.emptySet();
                }
            }
        }
        if (s.length() != originLength) { //如果预处理删除了一部分，判断预处理后的结果是不是符合要求
            return removeInvalidParentheses(s, left, right, mem);
        }

        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0 && c == s.charAt(i - 1)) {
                continue;
            }
            if (c == '(' || c == ')') {
                if ((left == 0 && c == '(') || (right == 0 && c == ')')) {
                    continue;
                }
                String newStr = s.substring(0, i) + s.substring(i + 1, s.length());
                if (mem.contains(newStr)) {
                    continue;
                } else {
                    mem.add(newStr);
                }
                Set<String> res;
                if (c == '(') {
                    res = removeInvalidParentheses(newStr, left - 1, right, mem);
                } else {
                    res = removeInvalidParentheses(newStr, left, right - 1, mem);
                }
                result.addAll(res);
            }
        }
        return result;
    }

    private int[] getDeleteCount(String s) {
        int[] res = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '(') {
                res[0]++;
            } else if (c == ')') {
                if (res[0] == 0) {
                    res[1]++;
                } else {
                    res[0]--;
                }
            }
        }
        return res;
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

