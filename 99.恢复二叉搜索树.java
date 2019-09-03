/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (54.66%)
 * Likes:    83
 * Dislikes: 0
 * Total Accepted:    5.4K
 * Total Submissions: 9.8K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * 二叉搜索树中的两个节点被错误地交换。
 * 
 * 请在不改变其结构的情况下，恢复这棵树。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * 输出: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * 输出: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 进阶:
 * 
 * 
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
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
    public void recoverTree(TreeNode root) {
        TreeNode[] error = {null, null};
        recoverTree(root, new TreeNode[]{null}, error);
        int tmp = error[0].val;
        error[0].val = error[1].val;
        error[1].val = tmp;
    }

    public void recoverTree(TreeNode root, TreeNode[] pre, TreeNode[] error) {
        if (root.left != null) {
            recoverTree(root.left, pre, error);
        }
        if (pre[0] != null && pre[0].val > root.val) {
            if (error[0] == null) {
                error[0] = pre[0];
            }
            error[1] = root;
        }
        pre[0] = root;

        if (root.right != null) {
            recoverTree(root.right, pre, error);
        }
    }
}

