/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 *
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (36.89%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    14.3K
 * Total Submissions: 37.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * 输出: 6
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * 输出: 42
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    public int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxPathSum(root.left, max);
        int cur = root.val;
        int right = maxPathSum(root.right, max);

        if (cur < 0) {
            if (cur/2 + left/2 < 0 && cur/2 + right/2 < 0) {
                max[0] = Math.max(max[0], Math.max(Math.max(left, right), cur));
                return Integer.MIN_VALUE;
            }
            if (cur/2 + left/2 < 0) {
                max[0] = Math.max(max[0], right);
                return cur + right;
            }
            if (cur/2 + right/2 < 0) {
                max[0] = Math.max(max[0], left);
                return cur + left;
            }
        }

        left = Math.max(0, left);
        right = Math.max(0, right);

        max[0] = Math.max(max[0], left + cur + right);
        return Math.max(cur + left, cur + right);
    }
}

