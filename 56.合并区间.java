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
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>(intervals.length);

        int[] ints = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (ints[1] >= intervals[i][0]) {
                ints[1] = Math.max(ints[1], intervals[i][1]);
            } else {
                list.add(ints);
                ints = intervals[i];
            }
        }
        list.add(ints);
        return list.toArray(new int[list.size()][]);
    }
}

