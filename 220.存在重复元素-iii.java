/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 *
 * https://leetcode-cn.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (24.69%)
 * Likes:    109
 * Dislikes: 0
 * Total Accepted:    10K
 * Total Submissions: 39.3K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j
 * 之间的差的绝对值最大为 ķ。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 
 * 示例 3:
 * 
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getId(num, w);
            if (map.get(id) != null) {
                return true;
            }
            if (map.get(id - 1) != null && num - Long.valueOf(map.get(id - 1)) <= t) {
                return true;
            }
            if (map.get(id + 1) != null && Long.valueOf(map.get(id + 1)) - num <= t) {
                return true;
            }
            map.put(id, num);
            if (map.size() > k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    private int getId(int value, int w) {
        if (value >= 0) {
            return value / w;
        }
        return (value + 1) / w - 1;
    }
}
// @lc code=end

