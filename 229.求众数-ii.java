/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 *
 * https://leetcode-cn.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (41.88%)
 * Likes:    103
 * Dislikes: 0
 * Total Accepted:    8.8K
 * Total Submissions: 20.9K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: [3]
 * 
 * 示例 2:
 * 
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Integer a = null;
        Integer b = null;
        int ac = 0;
        int bc = 0;
        for (int num : nums) {
            if (a != null && a == num) {
                ac++;
                continue;
            }
            if (b != null && b == num) {
                bc++;
                continue;
            }
            if (ac == 0) {
                a = num;
                ac++;
                continue;
            }
            if (bc == 0) {
                b = num;
                bc++;
                continue;
            }
            ac--;
            bc--;
        }
        ac = 0;
        bc = 0;
        for (int num : nums) {
            if (num == a) {
                ac++;
            } else if (num == b) {
                bc++;
            }
        }
        if (ac > nums.length / 3.0) {
            result.add(a);
        }
        if (bc > nums.length / 3.0) {
            result.add(b);
        }
        return result;
    }
}
// @lc code=end

