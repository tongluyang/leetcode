/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (39.98%)
 * Likes:    120
 * Dislikes: 0
 * Total Accepted:    15.7K
 * Total Submissions: 37.9K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 
 * 示例 4:
 * 
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * 
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        final String[] strings = str.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        Map<Character, String> c2word = new HashMap<>();
        Map<String, Character> word2c = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            final String word = c2word.getOrDefault(pattern.charAt(i), strings[i]);
            if (!word.equals(strings[i])) {
                return false;
            }
            final Character c = word2c.getOrDefault(strings[i], pattern.charAt(i));
            if (!c.equals(pattern.charAt(i))) {
                return false;
            }
            c2word.put(pattern.charAt(i), word);
            word2c.put(strings[i], c);
        }
        return true;
    }
}
// @lc code=end

