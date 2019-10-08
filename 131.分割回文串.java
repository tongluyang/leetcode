/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (63.24%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    13.7K
 * Total Submissions: 21.4K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<>(), s.toCharArray(), 0, s.length() - 1);
        return result;
    }

    private void partition(List<List<String>> result, List<String> pre, char[] cs, int start, int end) {
        if (start > end) {
            result.add(pre);
            return;
        }
        for (int i = start; i <= end; i++) {
            if (isPalindrome(cs, start, i)) {
                ArrayList<String> newPre = new ArrayList<>(pre);
                newPre.add(new String(cs, start, i - start + 1));
                partition(result, newPre, cs, i + 1, end);
            }
        }
    }
    
    private boolean isPalindrome(char[] cs, int start, int end) {
        while (start < end) {
            if (cs[start] != cs[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

