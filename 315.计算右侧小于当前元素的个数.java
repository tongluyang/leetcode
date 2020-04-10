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
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return list;
        }
        int[] indexes = new int[len];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        int[] res = new int[len];
        int[] tmp = new int[len];
        mergeSort(nums, indexes, 0, len - 1, res, tmp);
        for (int c : res) {
            list.add(c);
        }
        return list;
    }

    private void mergeSort(int[] nums, int[] indexes, int l, int r, int[] res, int[] tmp) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, indexes, l, mid, res, tmp);
        mergeSort(nums, indexes,mid + 1, r, res, tmp);

        int i = l;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= r && nums[indexes[i]] > nums[indexes[j]]) {
                j++;
            }
            res[indexes[i]] += j - mid - 1;
            i++;
        }

        if (l == 0 && r == nums.length - 1) {
            return;
        }
        System.arraycopy(indexes, l, tmp, l, r - l + 1);
        int p1 = l;
        int p2 = mid + 1;
        i = l;

        while (p1 <= mid || p2 <= r) {
            if (p2 > r || (p1 <= mid && nums[tmp[p1]] < nums[tmp[p2]])) {
                indexes[i++] = tmp[p1++];
            } else {
                indexes[i++] = tmp[p2++];
            }
        }
    }
}
// @lc code=end

