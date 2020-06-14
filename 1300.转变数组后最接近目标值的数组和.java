/*
 * @lc app=leetcode.cn id=1300 lang=java
 *
 * [1300] 转变数组后最接近目标值的数组和
 *
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/description/
 *
 * algorithms
 * Medium (44.64%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    12.1K
 * Total Submissions: 26K
 * Testcase Example:  '[4,9,3]\n10'
 *
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value
 * 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 
 * 请注意，答案不一定是 arr 中的数字。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 
 * 
 * 示例 2：
 * 
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 
 * 
 * 示例 3：
 * 
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        Arrays.sort(arr);
        int value = (int) Math.round(target * 1.0 / len - 0.00000001);//如果value是xxx.5，说明进位或舍位一样，由于要取较小的数，所以舍位
        for (int i = 0; i < len; i++) {
            if (arr[i] >= value) {
                return value;
            }
            target -= arr[i];
            value = (int) Math.round(target * 1.0 / (len - i - 1) - 0.00000001);
        }
        return arr[len - 1];
    }
}
// @lc code=end

