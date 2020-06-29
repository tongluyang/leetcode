/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 *
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (35.01%)
 * Likes:    133
 * Dislikes: 0
 * Total Accepted:    27.8K
 * Total Submissions: 79.4K
 * Testcase Example:  '[3,2,1]'
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3, 2, 1]
 * 
 * 输出: 1
 * 
 * 解释: 第三大的数是 1.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1, 2]
 * 
 * 输出: 2
 * 
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: [2, 2, 3, 1]
 * 
 * 输出: 1
 * 
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        Integer[] arr = new Integer[3];
        for (int num : nums) {
            update(num, arr);
        }
        return arr[2] == null ? arr[0] : arr[2];
    }
    
    private void update(int num, Integer[] arr) {
        for (int i = 0; i < 3; i++) {
            if (arr[i] == null || arr[i] == num) {
                arr[i] = num;
                return;
            }
            if (num > arr[i]) {
                int tmp = arr[i];
                arr[i] = num;
                num = tmp;
            }
        }
    }
}
// @lc code=end

