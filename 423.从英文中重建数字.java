/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 *
 * https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/description/
 *
 * algorithms
 * Medium (53.20%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    4K
 * Total Submissions: 7.4K
 * Testcase Example:  '"owoztneoer"'
 *
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * 
 * 注意:
 * 
 * 
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: "owoztneoer"
 * 
 * 输出: "012" (zeroonetwo)
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "fviefuro"
 * 
 * 输出: "45" (fourfive)
 * 
 * 
 */

// @lc code=start
class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        //z ero  t w o  fo u r  si x  ei g ht
        count[0] += map['z' - 'a'];
        map['e' - 'a'] -= map['z' - 'a'];
        map['r' - 'a'] -= map['z' - 'a'];
        map['o' - 'a'] -= map['z' - 'a'];
        map['z' - 'a'] = 0;

        count[2] += map['w' - 'a'];
        map['t' - 'a'] -= map['w' - 'a'];
        map['o' - 'a'] -= map['w' - 'a'];
        map['w' - 'a'] = 0;

        count[4] += map['u' - 'a'];
        map['f' - 'a'] -= map['u' - 'a'];
        map['o' - 'a'] -= map['u' - 'a'];
        map['r' - 'a'] -= map['u' - 'a'];
        map['u' - 'a'] = 0;

        count[6] += map['x' - 'a'];
        map['s' - 'a'] -= map['x' - 'a'];
        map['i' - 'a'] -= map['x' - 'a'];
        map['x' - 'a'] = 0;

        count[8] += map['g' - 'a'];
        map['e' - 'a'] -= map['g' - 'a'];
        map['i' - 'a'] -= map['g' - 'a'];
        map['h' - 'a'] -= map['g' - 'a'];
        map['t' - 'a'] -= map['g' - 'a'];
        map['g' - 'a'] = 0;

        //o ne  t hree  f ive  s even  n i ne
        count[1] += map['o' - 'a'];
        map['n' - 'a'] -= map['o' - 'a'];
        map['e' - 'a'] -= map['o' - 'a'];
        map['o' - 'a'] = 0;

        count[3] += map['t' - 'a'];
        map['h' - 'a'] -= map['t' - 'a'];
        map['r' - 'a'] -= map['t' - 'a'];
        map['e' - 'a'] -= map['t' - 'a'];
        map['e' - 'a'] -= map['t' - 'a'];
        map['t' - 'a'] = 0;

        count[5] += map['f' - 'a'];
        map['i' - 'a'] -= map['f' - 'a'];
        map['v' - 'a'] -= map['f' - 'a'];
        map['e' - 'a'] -= map['f' - 'a'];
        map['f' - 'a'] = 0;

        count[7] += map['s' - 'a'];
        map['e' - 'a'] -= map['s' - 'a'];
        map['v' - 'a'] -= map['s' - 'a'];
        map['e' - 'a'] -= map['s' - 'a'];
        map['n' - 'a'] -= map['s' - 'a'];
        map['s' - 'a'] = 0;

        count[9] += map['i' - 'a'];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

