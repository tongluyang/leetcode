/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 *
 * https://leetcode-cn.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (37.79%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    6.9K
 * Total Submissions: 18.7K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典
 * wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 
 * 说明：
 * 
 * 
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 
 * 
 * 示例 1：
 * 
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * 示例 2：
 * 
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String word : wordDict) {
            set.add(word);
            max = Math.max(max, word.length());
            min = Math.min(min, word.length());
        }
        return wordBreak(s, 0, set, new HashMap<>(), min, max);
    }

    private List<String> wordBreak(String source, int start, Set<String> wordDict, Map<Integer, List<String>> tail, int min, int max) {
        if (start == source.length()) {
            return Collections.singletonList("");
        }
        if (tail.get(start) != null) {
            return tail.get(start);
        }

        for (int length = min; start + length <= source.length() && length <= max; length++) {
            String word = source.substring(start, start + length);
            if (wordDict.contains(word)) {
                List<String> strings = wordBreak(source, start + length, wordDict, tail, min, max);
                List<String> list = tail.getOrDefault(start, new ArrayList<>());
                for (String string : strings) {
                    list.add(word + (string.equals("") ? "" : (" " + string)));
                }
                tail.put(start, list);
            }
        }
        return tail.getOrDefault(start, new ArrayList<>());
    }
}
// @lc code=end

