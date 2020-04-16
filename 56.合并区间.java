/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (36.57%)
 * Likes:    148
 * Dislikes: 0
 * Total Accepted:    20.8K
 * Total Submissions: 55.4K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int p0 = 0;
        int p1 = 1;
        while (p1 < intervals.length) {
            int[] pre = intervals[p0];
            int[] post = intervals[p1];
            if (pre[1] >= post[0]) {//吃掉
                pre[1] = pre[1] > post[1] ? pre[1] : post[1];
            } else {
                p0++;
                intervals[p0] = intervals[p1];
            }
            p1++;
        }
        int[][] res = new int[p0 + 1][2];
        System.arraycopy(intervals, 0, res, 0, p0 + 1);
        return res;
    }
}

