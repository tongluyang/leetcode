/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 *
 * https://leetcode-cn.com/problems/shuffle-an-array/description/
 *
 * algorithms
 * Medium (51.38%)
 * Likes:    69
 * Dislikes: 0
 * Total Accepted:    19.5K
 * Total Submissions: 37.9K
 * Testcase Example:  '["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]'
 *
 * 打乱一个没有重复元素的数组。
 * 
 * 
 * 
 * 示例:
 * 
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * 
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * 
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * 
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * 
 * 
 */

// @lc code=start
class Solution {

    int[] origin;
    public Solution(int[] nums) {
        this.origin = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    Random random = new Random();
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = origin.length;
        int[] res = new int[len];
        boolean[] visit = new boolean[len];
        int i = 0;
        while (i < len) {
            int idx = 0;
            int count = 1;
            for (int j = 0; j < len; j++) {
                if (visit[j]) {
                    continue;
                }
                if (random.nextInt(count++) == 0) {
                    idx = j;
                }
            }
            res[i++] = origin[idx];
            visit[idx] = true;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

