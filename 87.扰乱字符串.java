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
        Map<String, Boolean> mem = new HashMap<>();
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (int i = 0; i < chars1.length - 1; i++) {
            boolean left = true;
            boolean right = true;
            boolean[] booleansLeft = new boolean[i + 1];
            boolean[] booleansRight = new boolean[i + 1];
            for (int j = 0; j <= i; j++) {
                int idx = chars2.length;
                int lastIdx = -1;
                if (left) {
                    for (int x = 0; x <= i; x++) {
                        if (chars2[x] == chars1[j] && !booleansLeft[x]) {
                            booleansLeft[x] = true;
                            idx = x;
                            break;
                        }
                    }
                }
                if (right) {
                    for (int x = 0; x <= i; x++) {
                        if (chars2[chars2.length - 1 - x] == chars1[j] && !booleansRight[x]) {
                            booleansRight[x] = true;
                            lastIdx = chars2.length - 1 - x;
                            break;
                        }
                    }
                }

                if ((left && idx <= i)) {
                    left = true;
                    if (i == j && check(s1, s2, i, true, mem)) {
                        return true;
                    }
                } else {
                    left = false;
                }
                if (right && lastIdx >= s2.length() - 1 - i) {
                    right = true;
                    if (i == j && check(s1, s2, i, false, mem)) {
                        return true;
                    }
                } else {
                    right = false;
                }
                if (!left && !right) {
                    break;
                }
            }
        }

        return false;
    }

    public boolean check(String s1, String s2, int point, boolean left, Map<String, Boolean> mem) {
        String begin1 = s1.substring(0, point + 1);
        String begin2;
        if (left) {
            begin2 = s2.substring(0, point + 1);
        } else {
            begin2 = s2.substring(s2.length() - 1 - point);
        }

        String end1 = s1.substring(point + 1);
        String end2;
        if (left) {
            end2 = s2.substring(point + 1);
        } else {
            end2 = s2.substring(0, s2.length() - 1 - point);
        }
        Boolean b1 = null;
        Boolean b2 = null;

        String key1 = begin1 + "-" + begin2;
        if (mem.get(key1) != null) {
            b1 = mem.get(key1);
        }

        String key2 = end1 + "-" + end2;
        if (mem.get(key2) != null) {
            b2 = mem.get(key2);
        }
        if (b1 == null) {
            b1 = isScramble(begin1, begin2);
        }
        if (b2 == null) {
            b2 = isScramble(end1, end2);
        }
        return b1 && b2;
    }
}

