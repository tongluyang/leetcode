/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 *
 * https://leetcode-cn.com/problems/arithmetic-slices/description/
 *
 * algorithms
 * Medium (61.88%)
 * Likes:    139
 * Dislikes: 0
 * Total Accepted:    14.8K
 * Total Submissions: 23.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 
 * 例如，以下数列为等差数列:
 * 
 * 
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 
 * 以下数列不是等差数列。
 * 
 * 
 * 1, 1, 2, 5, 7
 * 
 * 
 * 
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * 
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * 
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * 
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * 
 * 
 * 
 * 示例:
 * 
 * 
 * A = [1, 2, 3, 4]
 * 
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int l = 0;
        int r = 2;
        int ans = 0;
        while (r < A.length) {
            int d = A[l + 1] - A[l];
            if (A[r] - A[r - 1] == d) {
                r++;
                if (r >= A.length) {
                    ans += count(l, r - 1);
                }
            } else {
                ans += count(l, r - 1);
                if (r - l == 2) {
                    r++;
                    l++;
                } else {
                    l = r - 2;
                }
            }
        }
        return ans;
    }

    private int count(int l, int r) {
        int len = r - l + 1;
        int ans = 0;
        int c = len;
        while (c >= 3) {
            ans += len - c + 1;
            c--;
        }
        return ans;
    }
}
// @lc code=end

