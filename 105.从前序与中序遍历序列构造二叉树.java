/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (60.14%)
 * Likes:    228
 * Dislikes: 0
 * Total Accepted:    22.4K
 * Total Submissions: 36.7K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, new int[1], inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] i, int[] inorder, int start, int end) {
        TreeNode root = new TreeNode(preorder[i[0]]);
        int mid = -1;
        for (int x = start; x <= end; x++) {
            if (inorder[x] == preorder[i[0]]) {
                mid = x;
                break;
            }
        }
        if (start < mid) {
            i[0]++;
            root.left = buildTree(preorder, i, inorder, start, mid - 1);
        }
        if (mid < end) {
            i[0]++;
            root.right = buildTree(preorder, i, inorder, mid + 1, end);
        }

        return root;
    }
}

