/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (57.24%)
 * Likes:    84
 * Dislikes: 0
 * Total Accepted:    23.3K
 * Total Submissions: 40.3K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] integers = new Integer[rowIndex + 1];
        integers[rowIndex] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            int insertIdx = rowIndex - i;
            integers[insertIdx] = 0;
            for (int j = insertIdx; j < rowIndex; j++) {
                integers[j] = integers[j] + integers[j + 1];
            }
        }

        return Arrays.asList(integers);
    }
}

