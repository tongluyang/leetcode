/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (59.35%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    20.5K
 * Total Submissions: 33.5K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 
 */

// @lc code=start
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(result, "", root);
        return result;
    }

    private void binaryTreePaths(List<String> result, String parent, TreeNode root) {
        if (root == null) {
            return;
        }
        if (!parent.toString().equals("")) {
            parent += "->";
        }
        parent += root.val;
        if (root.left == null && root.right == null) {
            result.add(parent.toString());
            return;
        }
        binaryTreePaths(result, parent, root.left);
        binaryTreePaths(result, parent, root.right);
    }
}
// @lc code=end

