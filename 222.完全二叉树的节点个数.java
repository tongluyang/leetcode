/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 *
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (55.30%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    10.5K
 * Total Submissions: 16.7K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 * 
 * 说明：
 * 
 * 
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第
 * h 层，则该层包含 1~ 2^h 个节点。
 * 
 * 示例:
 * 
 * 输入: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * 输出: 6
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {//左右子树高度相同，左子树为满二叉树，数量为2^level-1，算上root，为2^level，右子树不确定，递归计算
            return (1 << left) + countNodes(root.right);
        } else {//左右子树高度不同，右子树少一层，为满二叉树，数量同上，左子树不确定，递归计算
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
// @lc code=end

