/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 *
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (37.43%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    11.2K
 * Total Submissions: 29.9K
 * Testcase Example:  '[5,2,6,1]'
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于
 * nums[i] 的元素的数量。
 * 
 * 示例:
 * 
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0] 
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer num : set) {
            map.put(num, rank++);
        }
        final BIT bit = new BIT(set.size() + 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            rank = map.get(nums[i]);
            bit.inc(rank);
            final int count = bit.get(rank - 1);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    static class BIT {
        int[] tree;

        public BIT(int len) {
            this.tree = new int[len];
        }

        public void inc(int idx) {
            while (idx < tree.length) {
                tree[idx]++;
                idx += lowbit(idx);
            }
        }

        public int get(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= lowbit(idx);
            }
            return sum;
        }

        private int lowbit(int x) {
            return x & (-x);
        }
    }
}
// @lc code=end

