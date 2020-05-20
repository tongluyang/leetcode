/*
 * @lc app=leetcode.cn id=1371 lang=java
 *
 * [1371] 每个元音包含偶数次的最长子字符串
 *
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/
 *
 * algorithms
 * Medium (43.88%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    6.5K
 * Total Submissions: 11.6K
 * Testcase Example:  '"eleetminicoworoep"'
 *
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u'
 * ，在子字符串中都恰好出现了偶数次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findTheLongestSubstring(String s) {
        //相同奇偶性第一次出现的位置
        //奇偶只有00000-11111种可能性
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int res = 0;
        int status = 0;
        // 初始奇偶性是00000，位置为0
        pos[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                status ^= 1 << 0;
            } else if (c == 'e') {
                status ^= 1 << 1;
            } else if (c == 'i') {
                status ^= 1 << 2;
            } else if (c == 'o') {
                status ^= 1 << 3;
            } else if (c == 'u') {
                status ^= 1 << 4;
            }
            if (pos[status] < 0) {//第一次出现
                // aba
                // i == 0时，奇偶性为10000
                // 位置+1，因为空字符的奇偶性为00000，是所有情况的初始
                pos[status] = i + 1;
            } else {
                // aba
                // i == 2时，奇偶性为00000，第一次00000是空字符串
                int len = i + 1 - pos[status];
                if (len > res) {
                    res = len;
                }
            }
        }
        return res;
    }
}
// @lc code=end

