/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 *
 * https://leetcode-cn.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (34.96%)
 * Likes:    116
 * Dislikes: 0
 * Total Accepted:    9.4K
 * Total Submissions: 27K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 
 * 示例 2:
 * 
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * 
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * 
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int mid = findKthLargest(nums, (nums.length + 1) / 2);

        int lt = 0;
        int eq = 0;
        int gt = nums.length - 1;
        while (eq <= gt) {
            if (nums[eq] < mid) {
                swap(nums, eq++, lt++);
            } else if (nums[eq] > mid) {
                swap(nums, eq, gt--);
            } else {
                eq++;
            }
        }

        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);

        int i = 0;
        int j = nums.length - 1;
        int k = j / 2;
        while (i < nums.length) {
            nums[i++] = tmp[k--];
            if (i == nums.length) {
                break;
            }
            nums[i++] = tmp[j--];
        }
    }

    //leetcode 215 数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    Random random = new Random();

    private int findKthLargest(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        swap(nums, start, random.nextInt(end - start + 1) + start);
        int p = nums[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (nums[r] > p && r > l) {
                r--;
            }
            while (nums[l] <= p && r > l) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, start, r);

        int rightLen = end - r;
        if (k == rightLen + 1) {//左边数组第一个，也就是最大值，也就是分界数
            return p;
        }

        if (k <= rightLen) {//在大的一边
            return findKthLargest(nums, k, r + 1, end);
        } else {
            return findKthLargest(nums, k - rightLen - 1, start, r - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

