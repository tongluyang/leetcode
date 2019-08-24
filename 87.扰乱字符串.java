/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 *
 * https://leetcode-cn.com/problems/scramble-string/description/
 *
 * algorithms
 * Hard (43.47%)
 * Likes:    53
 * Dislikes: 0
 * Total Accepted:    3.3K
 * Total Submissions: 7.7K
 * Testcase Example:  '"great"\n"rgeat"'
 *
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * 
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 * 
 * ⁠   great
 * ⁠  /    \
 * ⁠ gr    eat
 * ⁠/ \    /  \
 * g   r  e   at
 * ⁠          / \
 * ⁠         a   t
 * 
 * 
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * 
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 * 
 * ⁠   rgeat
 * ⁠  /    \
 * ⁠ rg    eat
 * ⁠/ \    /  \
 * r   g  e   at
 * ⁠          / \
 * ⁠         a   t
 * 
 * 
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * 
 * 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
 * 
 * ⁠   rgtae
 * ⁠  /    \
 * ⁠ rg    tae
 * ⁠/ \    /  \
 * r   g  ta  e
 * ⁠      / \
 * ⁠     t   a
 * 
 * 
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * 
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 * 
 */
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        return check(c1, c2, 0, 0, c1.length);
    }

    public boolean check(char[] c1, char[] c2, int start1, int start2, int len) {
        if (len == 1) {
            return c1[start1] == c2[start2];
        }
        int[] ints = new int[26];
        for (int i = 0; i < len; i++) {
            ints[c1[start1 + i] - 'a']++;
            ints[c2[start2 + i] - 'a']--;
        }
        for (int i : ints) {
            if (i != 0) {
                return false;
            }
        }

        for (int i = 1; i < len; i++) {// i为相对start的分界点
            if ((check(c1, c2, start1, start2, i)//前半段匹配前半段
                    && check(c1, c2, start1 + i, start2 + i, len - i))//剩余后半段匹配剩余后半段
                    || (check(c1, c2, start1, start2 + len - i, i)//前半段匹配后半段
                    && check(c1, c2, start1 + i, start2, len - i))) {//剩余后半段匹配剩余前半段
                return true;
            }
        }

        return false;
    }

}

