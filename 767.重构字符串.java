/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 *
 * https://leetcode-cn.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (42.44%)
 * Likes:    192
 * Dislikes: 0
 * Total Accepted:    19.1K
 * Total Submissions: 41.5K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: S = "aab"
 * 输出: "aba"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: S = "aaab"
 * 输出: ""
 * 
 * 
 * 注意:
 * 
 * 
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int len = S.length();
        int maxCount = 0;
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
            maxCount = Math.max(count[c - 'a'], maxCount);
        }
        if (maxCount > len - maxCount + 1) {
            return "";
        }
        char[] chars = new char[len];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> count[b] - count[a]);
        for (int i = 0; i < 26; i++) {
            queue.add(i);
        }
        for (int i = 0; i < len; i++) {
            char c = (char) (queue.poll() + 'a');
            if (i > 0 && chars[i - 1] == c) {
                char next = (char) (queue.poll() + 'a');
                queue.add(c - 'a');
                c = next;
            }
            chars[i] = c;
            count[c - 'a']--;
            queue.add(c - 'a');
        }
        return new String(chars);
    }
}
// @lc code=end

