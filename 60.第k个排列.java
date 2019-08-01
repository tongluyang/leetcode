/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (46.37%)
 * Likes:    96
 * Dislikes: 0
 * Total Accepted:    10.8K
 * Total Submissions: 23.3K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */
class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> rem = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            rem.add(i);
        }
        String[] result = new String[1];
        getPermutation(n, k, new int[1], "", rem, result);
        return result[0];
    }

    public void getPermutation(int n, int k, int[] idx, String s, List<Integer> rem, String[] result) {

        if (s.length() == n) {
            idx[0] = idx[0] + 1;
        }

        if (idx[0] == k) {
            result[0] = s;
            return;
        }

        for (Integer integer : rem) {
            if (k > idx[0] + factorial(n - s.length()- 1)) {
                idx[0] = idx[0] + factorial(n - s.length() - 1);
                continue;
            }
            ArrayList<Integer> newRem = new ArrayList<>(rem);
            newRem.remove(integer);
            getPermutation(n, k, idx, s + integer, newRem, result);
            if (result[0] != null) {
                break;
            }
        }
    }

    public int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

}

