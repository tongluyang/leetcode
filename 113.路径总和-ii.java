/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (56.46%)
 * Likes:    122
 * Dislikes: 0
 * Total Accepted:    15.4K
 * Total Submissions: 27K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSum(result, new ArrayList<>(), root, 0, sum);
        return result;
    }

    private void pathSum(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum, int targetSum) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        if (root.left != null) {
            path.add(root.val);
            pathSum(result, path, root.left, sum + root.val, targetSum);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.val);
            pathSum(result, path, root.right, sum + root.val, targetSum);
            path.remove(path.size() - 1);
        }
    }
}

