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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = helper(root.left);
        int rightMax = helper(root.right);
        if (leftMax < 0) {
            leftMax = 0;
        }
        if (rightMax < 0) {
            rightMax = 0;
        }
        max = Math.max(max, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}