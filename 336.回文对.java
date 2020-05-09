/*
 * @lc app=leetcode.cn id=336 lang=java
 *
 * [336] 回文对
 *
 * https://leetcode-cn.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (33.21%)
 * Likes:    59
 * Dislikes: 0
 * Total Accepted:    3.5K
 * Total Submissions: 10.6K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * 
 * 示例 1:
 * 
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]] 
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]] 
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordsIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordsIndex.put(words[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int cur = 0; cur < words.length; cur++) {
            final String word = words[cur];
            final String reverse = new StringBuilder(word).reverse().toString();
            if (wordsIndex.containsKey(reverse) && wordsIndex.get(reverse) != cur) {
                res.add(Arrays.asList(cur, wordsIndex.get(reverse)));
            }


            List<String> suffix = new ArrayList<>();
            List<String> prefix = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                if (isPalindromeBetween(word, 0, i)) {//前部是回文，验证后缀有没有翻转字符串
                    suffix.add(word.substring(i + 1));
                }
                if (isPalindromeBetween(word, i, word.length() - 1)) {//后边是回文，验证前缀有没有翻转字符串
                    prefix.add(word.substring(0, i));
                }
            }
            for (String s : suffix) {
                final String r = new StringBuilder(s).reverse().toString();
                if (wordsIndex.containsKey(r)) {
                    res.add(Arrays.asList(wordsIndex.get(r), cur));
                }
            }
            for (String s : prefix) {
                final String r = new StringBuilder(s).reverse().toString();
                if (wordsIndex.containsKey(r)) {
                    res.add(Arrays.asList(cur, wordsIndex.get(r)));
                }
            }
        }

        return res;
    }
    
    private boolean isPalindromeBetween(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
// @lc code=end

