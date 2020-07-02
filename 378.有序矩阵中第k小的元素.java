/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第K小的元素
 *
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (59.16%)
 * Likes:    214
 * Dislikes: 0
 * Total Accepted:    20.7K
 * Total Submissions: 35K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * 
 * 
 * 
 * 示例:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * 返回 13。
 * 
 * 
 * 
 * 
 * 提示：
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n^2 。
 * 
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int mid = (min + max) >>> 1;
            if (count(matrix, mid) >= k) {//小于等于mid的数量，大于k，k在左半部分
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    
    private int count(int[][] matrix, int value) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= value) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
// @lc code=end

