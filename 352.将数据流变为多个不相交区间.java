/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 *
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/description/
 *
 * algorithms
 * Hard (53.82%)
 * Likes:    27
 * Dislikes: 0
 * Total Accepted:    1.8K
 * Total Submissions: 3.3K
 * Testcase Example:  '["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]\n[[],[1],[],[3],[],[7],[],[2],[],[6],[]]'
 *
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 * 
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 * 
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * 
 * 
 * 
 * 
 * 进阶：
 * 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 * 
 * 提示：
 * 特别感谢 @yunhong 提供了本问题和其测试用例。
 * 
 */

// @lc code=start
class SummaryRanges {
    List<int[]> all = new LinkedList<>();
    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {
        for (int i = 0; i < all.size(); i++) {
            int[] ints = all.get(i);
            if (val >= ints[0] && val <= ints[1]) {//在区间内，不用处理了
                return;
            }
            if (ints[0] - 1 == val) {//左边扩张一下
                ints[0] = val;
                return;
            }
            if (ints[1] + 1 == val) {//右边扩张
                ints[1] = val;
                //扩张后看能不能把右边一个吃掉
                if (i < all.size() - 1 && all.get(i + 1)[0] == val + 1) {
                    ints[1] = all.get(i + 1)[1];
                    all.remove(i + 1);
                }
                return;
            }
            if (ints[0] > val) {//后面的都比当前大了，可以插入到前面
                all.add(i, new int[]{val, val});
                return;
            }
        }
        all.add(new int[]{val, val});
    }

    public int[][] getIntervals() {
        int[][] res = new int[all.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = all.get(i);
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

