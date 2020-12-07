/*
 * @lc app=leetcode.cn id=659 lang=java
 *
 * [659] 分割数组为连续子序列
 *
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * algorithms
 * Medium (42.42%)
 * Likes:    249
 * Dislikes: 0
 * Total Accepted:    23.3K
 * Total Submissions: 43K
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度为 3 的子序列，其中每个子序列都由连续整数组成。
 * 
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 : 
 * 1, 2, 3
 * 3, 4, 5
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> end = new HashMap<>();
        for (int num : nums) {
            if (count.get(num) <= 0) {
                continue;
            }
            
            int c = end.getOrDefault(num - 1, 0);
            if (c == 0) {
                if (count.get(num) > 0
                        && count.getOrDefault(num + 1, 0) > 0
                        && count.getOrDefault(num + 2, 0) > 0) {
                    count.put(num, count.get(num) - 1);
                    count.put(num + 1, count.get(num + 1) - 1);
                    count.put(num + 2, count.get(num + 2) - 1);
                    end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);
                } else {
                    return false;
                }
            } else {
                end.put(num - 1, c - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
                count.put(num, count.get(num) - 1);
            }
        }
        return true;
    }
}
// @lc code=end

