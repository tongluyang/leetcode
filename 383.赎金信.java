/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 *
 * https://leetcode-cn.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (53.14%)
 * Likes:    91
 * Dislikes: 0
 * Total Accepted:    22.4K
 * Total Submissions: 42K
 * Testcase Example:  '"a"\n"b"'
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines
 * 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * 
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 
 * 
 * 
 * 注意：
 * 
 * 你可以假设两个字符串均只含有小写字母。
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len = ransomNote.length();
        if (len == 0) {
            return true;
        }
        int[] map = new int[26];
        for (int i = 0; i < len; i++) {
            char c = ransomNote.charAt(i);
            map[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            if (map[c - 'a'] > 0) {
                len--;
                map[c - 'a']--;
            }
            if (len == 0) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

