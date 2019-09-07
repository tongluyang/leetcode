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
        if (inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] idx = new int[1];
        idx[0] = postorder.length - 1;
        return buildTree(inorder, map, 0, inorder.length - 1, postorder, idx);
    }

    private TreeNode buildTree(int[] inorder, Map<Integer, Integer> map, int start, int end, int[] postorder, int[] idx) {
        TreeNode root = new TreeNode(postorder[idx[0]]);
        if (start == end) {
            return root;
        }
        int i = map.get(postorder[idx[0]]);
        if (i < end) {
            idx[0]--;
            root.right = buildTree(inorder, map, i + 1, end, postorder, idx);
        }
        if (start < i) {
            idx[0]--;
            root.left = buildTree(inorder, map, start, i - 1, postorder, idx);
        }

        return root;
    }
}

