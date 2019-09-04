/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (57.77%)
 * Likes:    261
 * Dislikes: 0
 * Total Accepted:    42.2K
 * Total Submissions: 72.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelOrder(result, root);
        return result;
    }

    private void levelOrder(List<List<Integer>> result, TreeNode root) {
        Queue<Object> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = (TreeNode) queue.poll();
            Integer level = (Integer) queue.poll();
            if (node != null && level != null) {
                List<Integer> row;
                if (result.size() > level) {
                    row = result.get(level);
                } else {
                    row = new ArrayList<>();
                    result.add(row);
                }
                row.add(node.val);

                queue.offer(node.left);
                queue.offer(level + 1);
                queue.offer(node.right);
                queue.offer(level + 1);
            }
        }
    }
}

