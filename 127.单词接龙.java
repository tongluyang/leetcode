/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (36.29%)
 * Likes:    137
 * Dislikes: 0
 * Total Accepted:    11K
 * Total Submissions: 29.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Set<String> upper = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            Set<String> curLevel = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                List<String> allNext = getAllNext(curWord, dict);
                for (String word : allNext) {
                    if (!upper.contains(word)) {
                        curLevel.add(word);
                        queue.offer(word);
                        if (endWord.equals(word)) {
                            return length + 1;
                        }
                    }
                }
            }
            upper.addAll(curLevel);
        }
        return 0;
    }

    private List<String> getAllNext(String word, Set<String> wordList) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            char origin = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (origin != c) {
                    chars[i] = c;
                    String s = new String(chars);
                    if (wordList.contains(s)) {
                        list.add(s);
                    }
                }
            }
        }
        return list;
    }
}

