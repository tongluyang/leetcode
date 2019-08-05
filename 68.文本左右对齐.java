/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 *
 * https://leetcode-cn.com/problems/text-justification/description/
 *
 * algorithms
 * Hard (39.71%)
 * Likes:    28
 * Dislikes: 0
 * Total Accepted:    2.8K
 * Total Submissions: 7K
 * Testcase Example:  '["This", "is", "an", "example", "of", "text", "justification."]\n16'
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 
 * 说明:
 * 
 * 
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。       
 * ⁠    第二行同样为左对齐，这是因为这行只包含一个单词。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * words =
 * ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * ⁠ "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 
 * 
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();

        StringBuilder row = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (row.length() == 0) {
                row.append(word);
                continue;
            }
            if (row.length() > 0 && row.length() + 1 + word.length() <= maxWidth) {
                row.append(" ").append(word);
            } else {
                result.add(insertSpace(row, maxWidth, false));

                row = new StringBuilder(word);
            }
        }
        result.add(insertSpace(row, maxWidth, true));

        return result;
    }

    private String insertSpace(StringBuilder row, int maxWidth, boolean isEnd) {
        String[] words = row.toString().split(" ");
        if (words.length == 1 || isEnd) {
            int rem = maxWidth - row.length();
            for (int i = 0; i < rem; i++) {
                row.append(" ");
            }
            return row.toString();
        }
        int spacesCount = (maxWidth - row.length() + (words.length - 1)) / (words.length - 1);
        int rem = (maxWidth - row.length() + (words.length - 1)) % (words.length - 1);

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (result.toString().equals("")) {
                result = new StringBuilder(word);
            } else {
                for (int i = 0; i < spacesCount; i++) {
                    result.append(" ");
                }
                result.append(rem-- > 0 ? " " : "").append(word);
            }
        }
        return result.toString();
    }
}

