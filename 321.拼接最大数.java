/*
 * @lc app=leetcode.cn id=321 lang=java
 *
 * [321] 拼接最大数
 *
 * https://leetcode-cn.com/problems/create-maximum-number/description/
 *
 * algorithms
 * Hard (27.74%)
 * Likes:    76
 * Dislikes: 0
 * Total Accepted:    2.3K
 * Total Submissions: 8.1K
 * Testcase Example:  '[3,4,6,5]\n[9,1,2,5,8,3]\n5'
 *
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n)
 * 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * 
 * 示例 1:
 * 
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 
 * 示例 2:
 * 
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 
 * 示例 3:
 * 
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * 
 */

// @lc code=start
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        Queue<P> queue = new LinkedList<>();
        queue.add(new P(0, 0));
        int rem = k;
        while (!queue.isEmpty() && rem > 0) {
            int size = queue.size();
            int max = -1;
            Map<Integer, List<Queue<P>>> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                final P p = queue.poll();
                int p1 = p.p1;
                int p2 = p.p2;
                Queue<P> tmpQueue = new LinkedList<>();
                int cur = maxEle(nums1, nums2, p1, p2, rem, tmpQueue);
                final List<Queue<P>> queues = map.computeIfAbsent(cur, key -> new ArrayList<>());
                queues.add(tmpQueue);
                if (cur > max) {
                    max = cur;
                }
            }
            for (Queue<P> tmpQueue : map.get(max)) {
                while (!tmpQueue.isEmpty()) {
                    final P p = tmpQueue.poll();
                    if (!queue.contains(p)) {
                        queue.add(p);
                    }
                }
            }
            res[k - rem] = max;
            rem--;
        }
        return res;
    }

    static class P {
        int p1;
        int p2;
        public P(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public boolean equals(Object obj) {
            return ((P) obj).p1 == p1 && ((P) obj).p2 == p2;
        }
    }

    private int maxEle(int[] num1, int[] num2, int p1, int p2, int rem, Queue<P> queue) {
        int max = -1;
        for (int num = 9; num >= 0 && (max == -1 || max == num); num--) {
            for (int i = p1; i <= num1.length && num1.length - i + num2.length - p2 >= rem; i++) {
                if (i < num1.length && num1[i] == num) {
                    max = num;
                    queue.add(new P(i + 1, p2));
                    break;
                }
            }

            for (int j = p2; j <= num2.length && num1.length - p1 + num2.length - j >= rem; j++) {
                if (j < num2.length && num2[j] == num) {
                    max = num;
                    queue.add(new P(p1, j + 1));
                    break;
                }
            }
        }
        return max;
    }
}
// @lc code=end

