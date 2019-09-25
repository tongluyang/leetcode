/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 *
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (26.91%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    3K
 * Total Submissions: 10.5K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 * 的最短转换序列。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: []
 * 
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        Queue<List<String>> queue = bfs(beginWord, endWord, wordList);
        return new ArrayList<>(queue);
    }

    public Queue<List<String>> bfs(String begin, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(begin);
        queue.offer(list);
        int minLevel = Integer.MAX_VALUE;
        int level = 0;
        Set<String> upper = new HashSet<>();
        while (!queue.isEmpty()) {
            if (level >= minLevel) {
                break;
            }

            int size = queue.size();
            Set<String> tmpSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> poll = queue.poll();
                String last = poll.get(poll.size() - 1);

                List<String> allNext = getAllNext(last, dict);
                for (String word : allNext) {
                    if (upper.contains(word)) {
                        continue;
                    }
                    tmpSet.add(word);
                    List<String> newList = new ArrayList<>(poll);
                    newList.add(word);
                    queue.offer(newList);

                    if (word.equals(end)) {
                        minLevel = level;
                    }
                }
            }
            upper.addAll(tmpSet);
            level++;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            List<String> poll = queue.poll();
            if (poll.get(poll.size() - 1).equals(end)) {
                queue.offer(new ArrayList<>(poll));
            }
        }
        return queue;
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

