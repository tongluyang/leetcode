/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (71.50%)
 * Likes:    149
 * Dislikes: 0
 * Total Accepted:    65.4K
 * Total Submissions: 89.4K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 
 * 
 * 示例 2：
 * 
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = A[i] * A[i];
        }
        int i = 0;
        for (; i < len - 1; i++) {
            if (tmp[i] < tmp[i + 1]) {
                break;
            }
        }
        int[] ans = new int[len];
        int j = 0;
        int l = i;
        int r = l + 1;
        while (j < len) {
            int min;
            if (r >= len || (l >= 0 && tmp[l] < tmp[r])) {
                min = tmp[l--];
            } else {
                min = tmp[r++];
            }
            ans[j++] = min;
        }
        return ans;
    }
}
// @lc code=end

