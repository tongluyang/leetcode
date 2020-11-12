/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/description/
 *
 * algorithms
 * Easy (68.27%)
 * Likes:    154
 * Dislikes: 0
 * Total Accepted:    55.3K
 * Total Submissions: 78.6K
 * Testcase Example:  '[4,2,5,7]'
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 
 * 你可以返回任何满足上述条件的数组作为答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int ie = 0;
        int io = 1;
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ans[ie] = A[i];
                ie += 2;
            } else {
                ans[io] = A[i];
                io += 2;
            }
        }
        return ans;
    }
}
// @lc code=end

