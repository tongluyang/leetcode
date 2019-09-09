/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (63.45%)
 * Likes:    171
 * Dislikes: 0
 * Total Accepted:    13.1K
 * Total Submissions: 20.3K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给定一个二叉树，原地将它展开为链表。
 * 
 * 例如，给定二叉树
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 将其展开为：
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
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
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        flatten(root, list);
        list.remove(0);
        TreeNode tmpRoot = root;
        root.left = null;
        for (Integer integer : list) {
            TreeNode right = new TreeNode(integer);
            tmpRoot.right = right;
            tmpRoot = right;
        }
    }

    private void flatten(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        flatten(root.left, list);
        flatten(root.right, list);
    }
}

