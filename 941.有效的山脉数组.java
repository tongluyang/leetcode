/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 *
 * https://leetcode-cn.com/problems/valid-mountain-array/description/
 *
 * algorithms
 * Easy (36.03%)
 * Likes:    90
 * Dislikes: 0
 * Total Accepted:    31.5K
 * Total Submissions: 80K
 * Testcase Example:  '[2,1]'
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * 
 * 
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * 
 * A[0] < A[1] < ... A[i-1] < A[i] 
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[2,1]
 * 输出：false
 * 
 * 
 * 示例 2：
 * 
 * 输入：[3,5,5]
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 输入：[0,3,2,1]
 * 输出：true
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int status = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                return false;
            }
            if (status == 0) {//初始状态
                if (A[i] > A[i - 1]) {//只能上升
                    status = 1;
                    continue;
                } else {
                    return false;
                }
            } else if (status == 1) {//上升状态
                if (A[i] > A[i - 1]) {
                    continue;
                } else if (A[i] < A[i - 1]) {//切换为下降状态
                    status = 2;
                }
            } else if (status == 2) {//下降状态
                if (A[i] > A[i - 1]) {
                    return false;
                }
            }
        }
        return status == 2;
    }
}
// @lc code=end

