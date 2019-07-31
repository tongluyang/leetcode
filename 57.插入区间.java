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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(intervals.length);
        if (intervals.length == 0) {
            list.add(newInterval);
            return list.toArray(new int[list.size()][]);
        }
        int[] ints;
        boolean inserted = false;
        if (newInterval[0] <= intervals[0][0]) {
            ints = newInterval;
            inserted = true;
        } else {
            ints = intervals[0];
        }
        for (int i = 0; i < intervals.length; i++) {
            if (!inserted && newInterval[0] < intervals[i][0]) {
                if (ints[1] >= newInterval[0]) {
                    ints[1] = Math.max(ints[1], newInterval[1]);
                } else {
                    list.add(ints);
                    ints = newInterval;
                }

                i--;
                inserted = true;
                continue;
            }

            if (ints[1] >= intervals[i][0]) {
                ints[1] = Math.max(ints[1], intervals[i][1]);
            } else {
                list.add(ints);
                ints = intervals[i];
            }
        }

        if (!inserted) {
            if (ints[1] >= newInterval[0]) {
                ints[1] = Math.max(ints[1], newInterval[1]);
            } else {
                list.add(ints);
                ints = newInterval;
            }
        }

        list.add(ints);
        return list.toArray(new int[list.size()][]);
    }
}

