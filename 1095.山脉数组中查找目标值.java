/*
 * @lc app=leetcode.cn id=1095 lang=java
 *
 * [1095] 山脉数组中查找目标值
 *
 * https://leetcode-cn.com/problems/find-in-mountain-array/description/
 *
 * algorithms
 * Hard (30.78%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    6.1K
 * Total Submissions: 16.9K
 * Testcase Example:  '[1,2,3,4,5,3,1]\n3'
 *
 * （这是一个 交互式问题 ）
 * 
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index
 * 值。
 * 
 * 如果不存在这样的下标 index，就请返回 -1。
 * 
 * 
 * 
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * 
 * 首先，A.length >= 3
 * 
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * 
 * 
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 
 * 
 * 
 * 
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 * 
 * 
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 * 
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例
 * “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 
 * 示例 2：
 * 
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 * 
 * 
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        return helper(target, mountainArr, 0, len - 1, len);
    }
    
    private int helper(int target, MountainArray mountainArr, int left, int right, int len) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int val = mountainArr.get(mid);
        if (val == target) {//找到一个，但是还不确定是不是最左边的，如果现在在山顶右侧，还需要在左边找，找到用左边的，找不到再用这个
            if (mid - 1 >= 0 && mountainArr.get(mid - 1) > val) {//前一个大，说明在山顶右侧
                int i = helper(target, mountainArr, left, mid - 1, len);
                if (i > -1) {
                    return i;
                }
            }
            return mid;
        } else if (val < target) {//需要往山顶找，山顶可能在左边也可能在右边
            if (mid + 1 < len && mountainArr.get(mid + 1) > val) {//后一个比当前大，现在在山顶左边，需要向右找，左边肯定没有
                return helper(target, mountainArr, mid + 1, right, len);
            } else {//后一个比当前小，现在在山顶右边，向左找，右边肯定没有
                return helper(target, mountainArr, left, mid - 1, len);
            }
        } else {//需要往山脚下找，也可能在这边山脚，也可能在另一边山脚
            int i = helper(target, mountainArr, left, mid - 1, len);
            if (i == -1) {
                return helper(target, mountainArr, mid + 1, right, len);
            }
            return i;
        }
    }
}
// @lc code=end

