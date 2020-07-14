/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 *
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 *
 * algorithms
 * Medium (58.56%)
 * Likes:    138
 * Dislikes: 0
 * Total Accepted:    5K
 * Total Submissions: 8.5K
 * Testcase Example:  '[3,10,5,25,2,8]'
 *
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 2^31 。
 * 
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 * 
 * 你能在O(n)的时间解决这个问题吗？
 * 
 * 示例:
 * 
 * 
 * 输入: [3, 10, 5, 25, 2, 8]
 * 
 * 输出: 28
 * 
 * 解释: 最大的结果是 5 ^ 25 = 28.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        int maxNum = 0;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        int lb = Integer.toBinaryString(maxNum).length();
        Set<Integer> prefixes = new HashSet<>();
        for (int i = lb - 1; i >= 0; i--) {
            prefixes.clear();
            ans <<= 1;
            //预期的最大xor
            int max = ans | 1;
            for (int num : nums) {
                prefixes.add(num >> i);
            }
            for (int pre : prefixes) {
                if (prefixes.contains(pre ^ max)) {//前缀里有一个数和pre异或是预期最大的
                    ans = max;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

