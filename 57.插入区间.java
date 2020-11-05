/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (34.37%)
 * Likes:    51
 * Dislikes: 0
 * Total Accepted:    6.7K
 * Total Submissions: 19.5K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 
 */
class Solution {
    int[][] tmp;
    int count = 0;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0) {
            return new int[][]{newInterval};
        }
        tmp = new int[len + 1][2];
        for (int i = 0; i < len; i++) {
            int[] interval = intervals[i];
            int max = interval[1];
            newInterval = merge(interval, newInterval);
            //最大值没变，或者是最后一个了，插入合并的数组，后面的直接copy
            if (newInterval[1] == max || i == len - 1) {
                tmp[count++] = newInterval;
                System.arraycopy(intervals, i + 1, tmp, count, len - i - 1);
                count += len - i - 1;
                break;
            }
        }
        int[][] ans = new int[count][2];
        System.arraycopy(tmp, 0, ans, 0, count);
        return ans;
    }

    private int[] merge(int[] interval, int[] newInterval) {
        if (newInterval[1] < interval[0]) {//插入前面，不相交
            tmp[count++] = newInterval;
            return interval;
        }
        if (interval[1] < newInterval[0]) {//后面，不相交
            tmp[count++] = interval;
            return newInterval;
        }
        int[] merged = new int[2];
        merged[0] = Math.min(interval[0], newInterval[0]);
        merged[1] = Math.max(interval[1], newInterval[1]);
        return merged;
    }
}
