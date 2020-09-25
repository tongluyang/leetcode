/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (62.92%)
 * Likes:    111
 * Dislikes: 0
 * Total Accepted:    13.1K
 * Total Submissions: 20.4K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end, int rootIdx) {
        if (rootIdx < 0 || start > end) {
            return null;
        }
        int val = postorder[rootIdx];
        TreeNode root = new TreeNode(val);
        if (start == end) {
            return root;
        }
        int inroot = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val) {
                inroot = i;
                break;
            }
        }
        root.left = helper(inorder, postorder, start, inroot - 1, rootIdx - (end - (inroot - 1)));
        root.right = helper(inorder, postorder, inroot + 1, end, rootIdx - 1);
        return root;
    }
}

