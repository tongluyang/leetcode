/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 *
 * https://leetcode-cn.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (72.28%)
 * Likes:    311
 * Dislikes: 0
 * Total Accepted:    32.5K
 * Total Submissions: 43.2K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[26];
        char[] chars = S.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        int l = 0;
        Set<Character> set = new HashSet<>();
        int[] tmp = new int[26];
        for (char c : chars) {
            set.add(c);
            l++;
            tmp[c - 'a']++;
            boolean split = true;
            for (char x : set) {
                if (tmp[x - 'a'] != count[x - 'a']) {
                    split = false;
                    break;
                }
            }
            if (split) {
                set.clear();
                ans.add(l);
                l = 0;
            }
        }
        return ans;
    }
}
// @lc code=end

