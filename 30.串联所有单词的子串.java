/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 *
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (26.45%)
 * Likes:    98
 * Dislikes: 0
 * Total Accepted:    8K
 * Total Submissions: 30.2K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入：
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * 输出：[]
 * 
 * 
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> integers = new ArrayList<>();
        if (words.length == 0) {
            return integers;
        }

        bt(integers, true, s, 0, words, new boolean[words.length]);

        return integers;
    }

    public void bt(List<Integer> integers, boolean isFirst, String s, int start, String[] words, boolean[] flags) {
        boolean hasFalse = false;
        for (boolean flag : flags) {
            if (!flag) {
                hasFalse = true;
                break;
            }
        }

        if (!hasFalse) {
            System.out.println(System.currentTimeMillis());
            int index = start - words[0].length() * words.length;
            if (!integers.contains(index)) {
                integers.add(index);
            }
            return;
        }

        Set<String> finishWords = new HashSet<>();
        int minStart = start;

        for (int i = 0; i < words.length; i++) {
            if (!flags[i]) {
                int idx;
                do {

                    if (finishWords.contains(words[i])) {
                        idx = s.indexOf(words[i], start);
                        if ((idx - start) % words[i].length() != 0) {
                            return;
                        }
                        break;
                    } else {
                        finishWords.add(words[i]);
                    }

                    if (!isFirst) {
                        if (!s.substring(start, start + words[i].length()).equals(words[i])) {


                            break;
                        }
                        idx = start;
                    } else {

                        idx = s.indexOf(words[i], start);

                        if (idx > s.length() - words[0].length() * words.length) {
                            break;
                        }
                    }


                    if (idx > -1) {
//                        boolean[] booleans = new boolean[flags.length];

//                        System.arraycopy(flags, 0, booleans, 0, flags.length);

                        flags[i] = true;

                        bt(integers, false, s, idx + words[i].length(), words, flags);

                        flags[i] = false;

                        if (isFirst) {
                            start = idx + 1;
                            finishWords.clear();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } while (true);

                start = minStart;
            }
        }
    }
}

