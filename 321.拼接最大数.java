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
        int m = nums1.length;
        int n = nums2.length;
        int start = Math.max(0, k - n);
        int end = Math.min(m, k);
        int[] max = new int[k];
        for (int i = start; i <= end; i++) {
            int[] maxseq1 = maxseq(nums1, i);
            //System.out.println(Arrays.toString(maxseq1));
            int[] maxseq2 = maxseq(nums2, k - i);
            //System.out.println(Arrays.toString(maxseq2));
            int[] seq = merge(maxseq1, maxseq2);
            //System.out.println(Arrays.toString(seq));
            if (compare(seq, max, 0, 0) > 0) {
                System.arraycopy(seq, 0, max, 0, k);
            }
        }
        return max;
    }

    private int compare(int[] seq1, int[] seq2, int start1, int start2) {
        int len = Math.min(seq1.length - start1, seq2.length - start2);
        for (int i = 0; i < len; i++) {
            if (seq1[i + start1] > seq2[i + start2]) {
                return 1;
            } else if (seq1[i + start1] < seq2[i + start2]) {
                return -1;
            }
        }
        return (seq1.length - start1) - (seq2.length - start2);
    }

    private int[] merge(int[] seq1, int[] seq2) {
        int len1 = seq1.length;
        int len2 = seq2.length;
        int[] seq = new int[len1 + len2];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < len1 || p2 < len2) {
            if (p1 >= len1) {
                seq[i++] = seq2[p2++];
                continue;
            }
            if (p2 >= len2) {
                seq[i++] = seq1[p1++];
                continue;
            }
            if (seq1[p1] < seq2[p2]) {
                seq[i++] = seq2[p2++];
            } else if (seq1[p1] > seq2[p2]) {
                seq[i++] = seq1[p1++];
            } else {
                if (compare(seq1, seq2, p1 + 1, p2 + 1) > 0) {
                    seq[i++] = seq1[p1++];
                } else {
                    seq[i++] = seq2[p2++];
                }
            }
        }
        return seq;
    }

    private int[] maxseq(int[] nums, int k) {
        int len = nums.length;
        //最多能丢弃的数量
        int drop = len - k;
        int[] stack = new int[k];
        int top = -1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (true) {
                //第一个数或比上一个数小或相等，留着
                if (top < 0 || num <= stack[top]) {
                    //满了
                    if (top + 1 == k) {
                        break;
                    }
                    stack[++top] = num;
                    break;
                } else {
                    //比上一个数大，前一个丢掉
                    //前提是有能丢的
                    //并且后面剩下的数字要能填满stack
                    if (drop > 0 && (len - i) >= (k - top)) {
                        top--;
                        drop--;
                    } else {
                        stack[++top] = num;
                        break;
                    }
                }
            }
        }
        return stack;
    }
}
// @lc code=end

