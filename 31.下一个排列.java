/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.92%)
 * Likes:    206
 * Dislikes: 0
 * Total Accepted:    15.1K
 * Total Submissions: 48.8K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int index1 = -1;
        int index2 = nums.length - 1;
        int value = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                index1 = i - 1;
                value = nums[i];
                index2 = i;
                break;
            }
        }

        if (index1 == -1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }

            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                nums[i] = list.get(i);
            }
            return;
        }

        for (int i = index1 + 1; i < nums.length; i++) {
            if (nums[i] > nums[index1] && nums[i] < value) {
                value = nums[i];
                index2 = i;

                if (nums[i] - 1 == nums[index1]) {
                    break;
                }
            }
        }

        int tmpValue = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmpValue;

        List<Integer> list = new ArrayList<>();
        for (int i = index1 + 1; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);

        for (int i = index1 + 1; i < nums.length; i++) {
            nums[i] = list.get(i - index1 - 1);
        }

    }
}

